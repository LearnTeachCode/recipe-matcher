package devApp.entity.recipe.service;

import java.util.List;
import java.util.Set;

import devApp.entity.recipe.model.Recipe;

public interface RecipeService {

	public void saveRecipe(Recipe recipe);
	
	public Recipe getRecipeById(int id);
	
	public void deleteRecipe(int id);
	
	public List<Recipe> listRecipes();
	
	public List<Recipe> matchRecipes(Set<String> inputIngredientNamesSet, int percentage);
}
