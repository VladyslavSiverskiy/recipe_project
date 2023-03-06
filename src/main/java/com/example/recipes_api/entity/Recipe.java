package com.example.recipes_api.entity;

import com.example.recipes_api.dao.StringListConverter;
import com.example.recipes_api.dto.RecipeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "recipes")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Integer id;

    @Column(name = "recipe_name")
    private String name;

    @Column(name = "recipe_description")
    private String description;


    @Convert(converter = StringListConverter.class)
    @Column(name = "recipe_ingredients")
    private List<String> ingredients = new ArrayList<>();

    @Convert(converter = StringListConverter.class)
    @Column(name = "recipe_directions")
    private List<String> directions = new ArrayList<>();

    public void addIngredients(List<String> ingredients){
        this.ingredients.addAll(ingredients);
    }

    public void addDirections(List<String> directions){
        this.directions.addAll(directions);
    }
}
