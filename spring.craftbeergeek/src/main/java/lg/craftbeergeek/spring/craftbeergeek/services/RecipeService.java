package lg.craftbeergeek.spring.craftbeergeek.services;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Recipe;
import lg.craftbeergeek.spring.craftbeergeek.dtos.RecipeDataDTO;

import java.util.List;

public interface RecipeService {
    Recipe addRecipe(RecipeDataDTO recipeData);

    List<RecipeDataDTO> allRecipesForUserById(Long id);

    List<RecipeDataDTO> findAllRecipes();

    void deleteRecipe(RecipeDataDTO recipeData);

}
