package lg.craftbeergeek.spring.craftbeergeek.domain.repositories;

import lg.craftbeergeek.spring.craftbeergeek.domain.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByUserId(Long userId);
}
