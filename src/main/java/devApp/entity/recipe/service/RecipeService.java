package devApp.entity.recipe.service;

import java.util.List;

import devApp.entity.recipe.model.Recipe;


public interface RecipeService {
	public void addRecipe(Recipe recipe);
	
	public void updateRecipe(Recipe recipe);
	
	public void deleteRecipe(int id);
	
	public Recipe getRecipeById(int id);
	
	public List<Recipe> listRecipes();
}
