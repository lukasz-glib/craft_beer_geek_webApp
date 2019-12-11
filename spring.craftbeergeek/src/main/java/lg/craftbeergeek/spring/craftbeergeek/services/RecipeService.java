package lg.craftbeergeek.spring.craftbeergeek.services;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Recipe;
import lg.craftbeergeek.spring.craftbeergeek.dtos.RecipeDataDTO;

import java.security.Principal;
import java.util.List;

public interface RecipeService {
    void addRecipe(RecipeDataDTO recipeData);

    List<RecipeDataDTO> findAllRecipes();

    List<Recipe> getOwnRecipesPage(Principal principal);

    void deleteRecipe(RecipeDataDTO recipeData, Long id);

    Recipe prepareUpdateForRecipe(Long id);


}
