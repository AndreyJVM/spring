package com.example.spring.data;

import com.example.spring.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

/** Retrieving all ingredients as a collection of {@code Ingredient} objects.
 * Getting one ingredient by ID.
 * Saving an object {@code Ingredient}
 * */

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}