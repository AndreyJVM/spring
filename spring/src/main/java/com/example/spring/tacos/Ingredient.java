package com.example.spring.tacos;

import lombok.Data;

/** У каждого ингредиента есть название и тип, позволяющие его визуально квалифицировать
 * */
@Data
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }
}