package com.example.spring.data;

import com.example.spring.tacos.IngredientRef;
import com.example.spring.tacos.Taco;
import com.example.spring.tacos.TacoOrder;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Types;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JdbcOrderRepository implements IOrderRepository {

    private JdbcOperations jdbcOperations;

    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    @Transactional
    public TacoOrder save(TacoOrder tacoOrder) {
        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
          "insert into Taco_Order "
          + "(delivery_name, delivery_street, delivery_city, " +
                  "delivery_state, delivery_zip, cc_number, " +
                  "cc_expiration, cc_cvv, placed_at) " +
                  "values (?,?,?,?,?,?,?,?,?)",
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
        );
        pscf.setReturnGeneratedKeys(true);

        tacoOrder.setPlacedAt(new Date());
        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        tacoOrder.getDeliveryName(),
                        tacoOrder.getDeliveryStreet(),
                        tacoOrder.getDeliveryCity(),
                        tacoOrder.getDeliveryState(),
                        tacoOrder.getDeliveryZip(),
                        tacoOrder.getCcNumber(),
                        tacoOrder.getCcExpiration(),
                        tacoOrder.getCcCVV(),
                        tacoOrder.getPlacedAt()));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long orderId = keyHolder.getKey().longValue();
        tacoOrder.setId(orderId);

        List<Taco> tacos = tacoOrder.getTacos();
        int i = 0;
        for (Taco taco : tacos){
            saveTaco(orderId, i++, taco);
        }
        return tacoOrder;
    }

    /**
     * Сохраняем объекты Taco связанные с заказом. Для каждого Taco в заказе
     * @return {@code tacoId}
     */
    private long saveTaco(long orderId, int orderKey, Taco taco) {
        taco.setCreateAt(new Date());
        PreparedStatementCreatorFactory pscf =
                new PreparedStatementCreatorFactory(
                        "insert into Taco " +
                                "(name, created_at, taco_order, taco_order_key) " +
                                "values (?, ?, ?, ?)",
                        Types.VARCHAR, Types.TIMESTAMP, Types.LONGVARCHAR, Types.LONGVARCHAR
                );
        pscf.setReturnGeneratedKeys(true);

        PreparedStatementCreator psc = pscf.newPreparedStatementCreator(
                Arrays.asList(
                        taco.getName(),
                        taco.getCreateAt(),
                        orderId,
                        orderKey));

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcOperations.update(psc, keyHolder);
        long tacoId = keyHolder.getKey().longValue();
        taco.setId(tacoId);

        saveIngredientRefs(tacoId, taco.getIngredients());

        return tacoId;
    }

    /** Циклически перебирает список объектов {@code Ingredient} и сохраняет каждый в таблице {@code Ingredient_Ref} */
    private void saveIngredientRefs(long tacoId, List<IngredientRef> ingredientsRefs) {
        int key = 0;

        for(IngredientRef ingredientsRef : ingredientsRefs){
            jdbcOperations.update(
                    "insert into Ingredient_Ref (ingredient, taco, taco_key) " +
                            "values (?, ?, ?)",
                    ingredientsRef.getIngredient(), tacoId, key++);
        }
    }
}