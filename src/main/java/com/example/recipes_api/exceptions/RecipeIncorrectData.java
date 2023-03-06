package com.example.recipes_api.exceptions;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RecipeIncorrectData {
    private String info;
}
