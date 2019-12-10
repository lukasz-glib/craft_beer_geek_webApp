package lg.craftbeergeek.spring.craftbeergeek.controllers;

import lg.craftbeergeek.spring.craftbeergeek.dtos.RecipeDataDTO;
import lg.craftbeergeek.spring.craftbeergeek.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.websocket.Decoder;
import java.util.List;

@Controller
@RequestMapping("/recipes")
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
    public String getOwnRecipesPage(Model model, Long id) {
        model.addAttribute("own-recipes", recipeService.allRecipesForUserById(id));
        return "recipe/all-own-recipes";
    }

    @GetMapping("/create")
    public String prepareCreationRecipeForm(Model model) {
        model.addAttribute("recipe", new RecipeDataDTO());
        return "recipe/add-recipe";
    }

    @PostMapping("/create")
    public String processCreationRecipeForm(@ModelAttribute @Valid RecipeDataDTO recipeDataDTO, BindingResult result) {
        if (result.hasErrors()) {
            return "recipe/add-recipe";
        }
        recipeService.addRecipe(recipeDataDTO);
        return "redirect:/recipes";
    }




}
