package com.example.recipes_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeDTO {

    private int id;
    private String name;
    private String description;
    private List<String> ingredients;
    private List<String> directions;

}
