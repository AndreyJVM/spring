package com.example.spring.tacos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;
import java.util.List;

/** Класс помогающий понять как объединяются ингредиенты {@code Ingredient}
 * */
@Data
@Table
public class Taco {

    @Id
    private Long id;

    @Id
    private Date createAt = new Date();

    @Id
    @Size(min=5, message = "Name must be at least 5 characters long")
    private String name;

    @Id
    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}