package devApp.entity.recipe.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import devApp.entity.recipe.model.Recipe;

@Repository
public interface RecipeDao extends CrudRepository<Recipe, Integer> {

	public List<Recipe> findAllByOrderByIsNewDescKeyDesc();
}
