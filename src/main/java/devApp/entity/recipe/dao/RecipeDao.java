package devApp.entity.recipe.dao;

import java.util.List;
import devApp.entity.recipe.model.Recipe;

public interface RecipeDao {

	public void add(Recipe recipe);
	
	public void update(Recipe recipe);

	public List<Recipe> listRecipes();

	public void delete(int id);

	public Recipe getRecipeById(int id);

}
