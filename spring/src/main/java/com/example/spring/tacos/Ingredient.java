package com.example.spring.tacos;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/** У каждого ингредиента есть название и тип, позволяющие его визуально квалифицировать
 * */
@Data
@Table
public class Ingredient {

    @Id
    private final String id;

    @Id
    private final String name;

    @Id
    private final Type type;

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }
}