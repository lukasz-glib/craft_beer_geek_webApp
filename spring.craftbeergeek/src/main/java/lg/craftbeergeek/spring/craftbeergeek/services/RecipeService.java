package lg.craftbeergeek.spring.craftbeergeek.services;

import lg.craftbeergeek.spring.craftbeergeek.dtos.RecipeDataDTO;

import java.util.List;

public interface RecipeService {
    void addRecipe(RecipeDataDTO recipeData);

    List<RecipeDataDTO> allRecipesForUserById(Long id);

    List<RecipeDataDTO> findAllRecipes();

}
