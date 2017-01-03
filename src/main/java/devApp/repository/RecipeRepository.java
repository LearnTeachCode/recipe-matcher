package devApp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import devApp.entity.recipe.model.Recipe;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Integer> {
	
}
