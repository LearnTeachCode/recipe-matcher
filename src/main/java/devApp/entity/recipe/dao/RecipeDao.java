package devApp.entity.recipe.dao;

import java.util.List;

import devApp.entity.recipe.model.Recipe;

public interface RecipeDao {

	public void addRecipe(Recipe recipe);
	
	public void updateRecipe(Recipe recipe);
	
	public void delteRecipe(int id);
	
	public Recipe getRecipeById(int id);
	
	public List<Recipe> listRecipes();

}
