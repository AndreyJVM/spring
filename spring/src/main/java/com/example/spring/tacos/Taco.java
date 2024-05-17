package com.example.spring.tacos;

import lombok.Data;
import java.util.List;

/** Класс помогающий понять как объединяются ингредиенты {@code Ingredient}
 * */
@Data
public class Taco {

    private String name;
    private List<Ingredient> ingredients;
}