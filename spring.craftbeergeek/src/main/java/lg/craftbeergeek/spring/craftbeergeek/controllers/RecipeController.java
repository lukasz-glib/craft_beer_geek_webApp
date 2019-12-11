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

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String getRecipesPage(Model model) {
        model.addAttribute("recipes", recipeService.findAllRecipes());
        return "recipe/all-recipes";
    }


    @GetMapping("/own-recipes")
    public String getOwnRecipesPage(Model model, Principal principal) {
        List<Recipe> recipes = recipeService.getOwnRecipesPage(principal);
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


    @GetMapping("/delete")
    public String processDeleteRecipe(RecipeDataDTO recipeData, Long id) {
        recipeService.deleteRecipe(recipeData, id);
        return "redirect:/recipes";
    }


    @GetMapping("/update")
    public String prepareUpdateForRecipe(Long id, Model model) {
        model.addAttribute("recipe", recipeService.prepareUpdateForRecipe(id));
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
