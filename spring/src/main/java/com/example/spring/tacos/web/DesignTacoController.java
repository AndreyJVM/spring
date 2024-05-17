package com.example.spring.tacos.web;

import com.example.spring.tacos.Ingredient;
import com.example.spring.tacos.Ingredient.Type;
import com.example.spring.tacos.Taco;
import com.example.spring.tacos.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/** Контроллер TacoCloud:
 * @принимает и обрабатывает HTTP-запросы GET с путём {@code /design}
 * @составляет список ингредиентов
 * @передает запрос и ингредиенты в шаблон представления, который будет преобразован в HTML и отправлен веб-браузеру
 * */

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        List<Ingredient> ingredients = Arrays.asList(
          new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
          new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
          new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
          new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
          new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
          new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
          new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
          new Ingredient("JACK", "Monterrey", Ingredient.Type.CHEESE),
          new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
          new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}