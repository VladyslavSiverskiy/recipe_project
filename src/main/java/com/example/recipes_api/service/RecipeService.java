package com.example.recipes_api.service;

import com.example.recipes_api.dao.RecipeRepository;
import com.example.recipes_api.dto.RecipeDTO;
import com.example.recipes_api.entity.Recipe;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public List<RecipeDTO> getAllRecipes() {
        List<RecipeDTO> recipeDTOS = new ArrayList<>();
        List<Recipe> recipes = recipeRepository.findAll();
        for (Recipe recipe : recipes) {
            RecipeDTO recipeDTO = new RecipeDTO(
                    recipe.getName(),
                    recipe.getDescription(),
                    recipe.getIngredients(),
                    recipe.getDirections()
            );
            recipeDTOS.add(recipeDTO);
        }
        return recipeDTOS;
    }

    public RecipeDTO getRecipeById(Integer recipeId){
        RecipeDTO recipeDTO = null;
        Optional<Recipe> recipeOptional = recipeRepository.findById(recipeId);
        if(recipeOptional.isPresent()){
            Recipe recipe = recipeOptional.get();
            recipeDTO = new RecipeDTO(
                    recipe.getName(),
                    recipe.getDescription(),
                    recipe.getIngredients(),
                    recipe.getDirections()
            );
        }

        return recipeDTO;
    }

    public Integer addRecipe(RecipeDTO recipeDTO) {
        System.out.println("RECIPE DTO: " + recipeDTO);
        Recipe recipe = new Recipe();
        recipe.setName(recipeDTO.getName());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.addIngredients(recipeDTO.getIngredients());
        recipe.addDirections(recipeDTO.getDirections());
        System.out.println("RECIPE: " + recipe);
        recipeRepository.save(recipe);
        return recipe.getId();
    }

    public boolean deleteRecipeById(int id){
        try {
            recipeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
