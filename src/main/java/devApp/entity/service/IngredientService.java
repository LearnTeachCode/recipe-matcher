package devApp.entity.service;

import java.util.List;

import devApp.entity.recipe.model.Ingredient;

public interface IngredientService {

	public void saveIngredient(Ingredient ingredient);
	
	public Ingredient getIngredientById(int id);
	
	public void deleteIngredient(int id);
	
	public List<Ingredient> listIngredients();
}
