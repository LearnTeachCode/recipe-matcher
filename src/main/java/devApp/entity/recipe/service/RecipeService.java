package devApp.entity.recipe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import devApp.entity.recipe.model.Recipe;

@Service
public interface RecipeService {
	
	public void add(Recipe recipe);
	
	public void update(Recipe recipe);
	
	public void delete(int id);
	
	public List<Recipe> listRecipes();
	
	public Recipe getRecipeById(int id);
}
