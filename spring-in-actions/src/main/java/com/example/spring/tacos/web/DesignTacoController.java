package com.example.spring.tacos.web;

import com.example.spring.data.IngredientRepository;
import com.example.spring.tacos.Ingredient;
import com.example.spring.tacos.Ingredient.Type;
import com.example.spring.tacos.Taco;
import com.example.spring.tacos.TacoOrder;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
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

    private final IngredientRepository ingredientRepository;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model){
        Iterable<Ingredient> ingredients = ingredientRepository.findAll();

        Type[] types = Ingredient.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType((List<Ingredient>) ingredients, type));
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

    @PostMapping
    public String processTaco(@Valid Taco taco, Errors errors, @ModelAttribute TacoOrder tacoOrder) {
        if(errors.hasErrors()){
            return "design";
        }

        tacoOrder.addTaco(taco);
        log.info("Processing taco: {}", taco);

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Ingredient.Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}