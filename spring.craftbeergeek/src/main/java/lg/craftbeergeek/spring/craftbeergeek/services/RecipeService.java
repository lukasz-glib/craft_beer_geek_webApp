package lg.craftbeergeek.spring.craftbeergeek.services;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Recipe;
import lg.craftbeergeek.spring.craftbeergeek.dtos.RecipeDataDTO;

import java.util.List;

public interface RecipeService {
    void addRecipe(RecipeDataDTO recipeData);

//    List<RecipeDataDTO> allRecipesForUserByUsername(RecipeDataDTO recipeData);

    List<RecipeDataDTO> findAllRecipes();

    void deleteRecipe(RecipeDataDTO recipeData, Long id);

}
