package com.example.spring.tacos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.Date;
import java.util.List;

/** Класс помогающий понять как объединяются ингредиенты {@code Ingredient}
 * */
@Data
public class Taco {

    private Date createAt = new Date();

    @Size(min=5, message = "Name must be at least 5 characters long")
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}