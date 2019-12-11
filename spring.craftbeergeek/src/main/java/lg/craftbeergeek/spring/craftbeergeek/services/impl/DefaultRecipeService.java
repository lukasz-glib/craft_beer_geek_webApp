package lg.craftbeergeek.spring.craftbeergeek.services.impl;


import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Recipe;
import lg.craftbeergeek.spring.craftbeergeek.domain.entities.User;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.RecipeRepository;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.UserRepository;
import lg.craftbeergeek.spring.craftbeergeek.dtos.RecipeDataDTO;
import lg.craftbeergeek.spring.craftbeergeek.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class DefaultRecipeService implements RecipeService {

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    public DefaultRecipeService(UserRepository userRepository, RecipeRepository recipeRepository) {
        this.userRepository = userRepository;
        this.recipeRepository = recipeRepository;
    }


    @Override
    public void addRecipe(RecipeDataDTO recipeData) {
        ModelMapper modelMapper = new ModelMapper();
        User user = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Recipe recipe = modelMapper.map(recipeData, Recipe.class);
        recipe.setUser(user);
        log.debug("Zapis przepisu: {}", recipe);
        recipeRepository.save(recipe);
        log.debug("Zapisano przepis do bazy: {}", recipe);
    }


    @Override
    public List<RecipeDataDTO> findAllRecipes() {
        ModelMapper modelMapperFindAll = new ModelMapper();
        return recipeRepository.findAll().stream()
                .map(m -> modelMapperFindAll.map(m, RecipeDataDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<Recipe> getOwnRecipesPage(Principal principal) {
        String username = principal.getName();
        return recipeRepository.findAllByUserUsername(username);
    }


    @Override
    public void deleteRecipe(RecipeDataDTO recipeData, Long id) {
        Recipe recipe = recipeRepository.findById(id).get();
        log.debug("Usunięcie przepisu: {}", recipe);
        if (recipe != null) {
            recipeRepository.delete(recipe);
        }
        log.debug("Usunięto przepis: {}", recipe);
    }

    @Override
    public Recipe prepareUpdateForRecipe(Long id) {
        Optional<Recipe> result = recipeRepository.findById(id);
        return result.get();
    }


}
