package lg.craftbeergeek.spring.craftbeergeek.controllers;

import lg.craftbeergeek.spring.craftbeergeek.dtos.RecipeDataDTO;
import lg.craftbeergeek.spring.craftbeergeek.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/recipe")
public class RecipeController {

    private final RecipeService recipeService;


    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public String getRecipesPage(Model model) {
        model.addAttribute("recipeDataDTO", new RecipeDataDTO());
        return "all-recipes";
    }
}
