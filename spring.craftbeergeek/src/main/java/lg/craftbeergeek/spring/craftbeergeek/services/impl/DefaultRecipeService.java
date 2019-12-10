package lg.craftbeergeek.spring.craftbeergeek.services.impl;


import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Recipe;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.RecipeRepository;
import lg.craftbeergeek.spring.craftbeergeek.domain.repositories.UserRepository;
import lg.craftbeergeek.spring.craftbeergeek.dtos.RecipeDataDTO;
import lg.craftbeergeek.spring.craftbeergeek.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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
        Recipe recipe = modelMapper.map(recipeData, Recipe.class);
        log.debug("Zapis przepisu: {}", recipe);
        recipeRepository.save(recipe);
        log.debug("Zapisano restaurację: {}", recipe);
    }

    @Override
    public List<RecipeDataDTO> allRecipesForUserById(Long id) {
        ModelMapper modelMapperFindAllById = new ModelMapper();
        return recipeRepository.findAllByUserId(id).stream()
                .map(m -> modelMapperFindAllById.map(m, RecipeDataDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<RecipeDataDTO> findAllRecipes() {
        ModelMapper modelMapperFindAll = new ModelMapper();
        return recipeRepository.findAll().stream()
                .map(m -> modelMapperFindAll.map(m, RecipeDataDTO.class))
                .collect(Collectors.toList());
    }


}
