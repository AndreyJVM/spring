package com.example.spring.data;

import com.example.spring.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/** Retrieving all ingredients as a collection of {@code Ingredient} objects.
 * Getting one ingredient by ID.
 * Saving an object {@code Ingredient}
 * */
public interface IIngredientRepository
        extends CrudRepository<Ingredient, String> {
}