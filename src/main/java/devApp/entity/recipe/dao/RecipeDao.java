package devApp.entity.recipe.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import devApp.entity.recipe.model.Recipe;

@Repository
public interface RecipeDao extends CrudRepository<Recipe, Integer> {
	
}
