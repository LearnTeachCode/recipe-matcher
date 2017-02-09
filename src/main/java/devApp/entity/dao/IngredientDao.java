package devApp.entity.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import devApp.entity.recipe.model.Ingredient;

@Repository
public interface IngredientDao extends CrudRepository<Ingredient, Integer> {
	
}
