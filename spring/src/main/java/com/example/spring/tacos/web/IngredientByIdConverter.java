package com.example.spring.tacos.web;

import com.example.spring.data.IIngredientRepository;
import com.example.spring.tacos.Ingredient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/** Реализован интерфейс {@code Convert} */
@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IIngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(IIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }
    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}