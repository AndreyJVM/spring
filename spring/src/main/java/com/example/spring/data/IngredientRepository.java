package com.example.spring.data;

import com.example.spring.tacos.Ingredient;
import java.util.Optional;

/** Retrieving all ingredients as a collection of {@code Ingredient} objects.
 * Getting one ingredient by ID.
 * Saving an object {@code Ingredient}
 * */
public interface IngredientRepository {

    Iterable<Ingredient> findAll();

    Optional<Ingredient> findById(String id);

    Ingredient save(Ingredient ingredient);
}
