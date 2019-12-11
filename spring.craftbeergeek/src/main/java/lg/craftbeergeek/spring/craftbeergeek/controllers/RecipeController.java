package lg.craftbeergeek.spring.craftbeergeek.controllers;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Recipe;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.RecipeRepository;
import lg.craftbeergeek.spring.craftbeergeek.dtos.RecipeDataDTO;
import lg.craftbeergeek.spring.craftbeergeek.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/recipes")
@Slf4j
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeService recipeService, RecipeRepository recipeRepository) {
        this.recipeService = recipeService;
        this.recipeRepository = recipeRepository;
    }

    @GetMapping
    public String getRecipesPage(Model model) {
        model.addAttribute("recipes", recipeService.findAllRecipes());
        return "recipe/all-recipes";
    }

//    @GetMapping("/own-recipes")
//    public String getOwnRecipesPage(Model model, Long id) {
//        model.addAttribute("own-recipes", recipeService.allRecipesForUserById(id));
//        return "recipe/all-own-recipes";
//    }

    @GetMapping("/own-recipes")
    public String getOwnRecipesPage(Model model, Principal principal) {
        String username = principal.getName();
        List<Recipe> recipes = recipeRepository.findAllByUserUsername(username);
        model.addAttribute("ownRecipes", recipes);
        return "recipe/all-own-recipes";
    }


    @GetMapping("/create")
    public String prepareCreationRecipeForm(Model model) {
        model.addAttribute("recipe", new RecipeDataDTO());
        return "recipe/add-recipe";
    }

    @PostMapping("/create")
    public String processCreationRecipeForm(@ModelAttribute("recipe") @Valid RecipeDataDTO recipeDataDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "recipe/add-recipe";
        }
        recipeService.addRecipe(recipeDataDTO);
        return "redirect:/recipes";
    }

    @GetMapping ("/delete")
    public String processDeleteRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id).get();
        if (recipe != null) {
            recipeRepository.delete(recipe);
        }
        return "redirect:/recipes";
    }

    @GetMapping("/update")
    public String prepareUpdateForRecipe(Long id, Model model) {
        Optional<Recipe> result = recipeRepository.findById(id);
        Recipe recipe = result.get();
        model.addAttribute("recipe", recipe);
        return "recipe/update-recipe";
    }

    @PostMapping("/update")
    public String processUpdateForRecipe (@ModelAttribute("recipe") @Valid RecipeDataDTO recipeData,
                                          BindingResult result) {
        log.warn(recipeData.toString());
        if (result.hasErrors()) {
            return "recipe/update-recipe";
        }
        recipeService.addRecipe(recipeData);
        return "redirect:/recipes";
    }

}
