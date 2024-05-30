package com.example.spring.tacos.data;

import com.example.spring.tacos.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}
