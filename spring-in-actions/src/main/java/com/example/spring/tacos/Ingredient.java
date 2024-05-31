package com.example.spring.tacos;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** У каждого ингредиента есть название и тип, позволяющие его визуально квалифицировать
 * */
@Data
@Document
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Ingredient {

    @Id
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