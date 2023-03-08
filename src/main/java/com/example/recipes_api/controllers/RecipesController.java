package com.example.recipes_api.controllers;

import com.example.recipes_api.dto.IdResponse;
import com.example.recipes_api.dto.RecipeDTO;
import com.example.recipes_api.exceptions.NoSuchRecipeException;
import com.example.recipes_api.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecipesController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/recipe")
    public List<RecipeDTO> getAllRecipes(){
        return recipeService.getAllRecipes();
    }

    @GetMapping("/recipe/{recipeId}")
    public RecipeDTO getRecipeById(@PathVariable Integer recipeId){
        RecipeDTO recipeDTO = recipeService.getRecipeById(recipeId);
        if(recipeDTO == null){
            throw new NoSuchRecipeException("Such recipe does not exists");
        }
        return recipeDTO;
    }

    @DeleteMapping("/recipe/{recipeId}")
    public IdResponse deleteEmployee(@PathVariable int recipeId){
        recipeService.deleteRecipeById(recipeId);
        IdResponse response = new IdResponse();
        response.setId(recipeId);
        return response;
    }

    @PostMapping("/recipe")
    public RecipeDTO addRecipe(@RequestBody RecipeDTO recipeDTO){
        return recipeService.addRecipe(recipeDTO);
    }
}
