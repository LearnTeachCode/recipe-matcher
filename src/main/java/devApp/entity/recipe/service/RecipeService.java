package devApp.entity.recipe.service;

import java.util.List;

import devApp.entity.recipe.model.Recipe;

public interface RecipeService {

	public void saveRecipe(Recipe recipe);
	
	public Recipe getRecipeById(int id);
	
	public void deleteRecipe(int id);
	
	public List<Recipe> listRecipes();
}
