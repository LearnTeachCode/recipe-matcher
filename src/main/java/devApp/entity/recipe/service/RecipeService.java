package devApp.entity.recipe.service;

import java.util.List;
import java.util.Set;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;

import devApp.entity.recipe.model.Recipe;

public interface RecipeService {

	@PreAuthorize("#recipe.owner == authentication.principal.id or hasAuthority('ADMIN')")
	public void saveRecipe(Recipe recipe);
	
	@PostAuthorize("returnObject.owner == authentication.principal.id or hasAuthority('ADMIN')")
	public Recipe getRecipeById(int id);
	
	@PreAuthorize("#recipe.owner == authentication.principal.id or hasAuthority('ADMIN')")
	public void deleteRecipe(Recipe recipe);
	
	@PostFilter("filterObject.owner == authentication.principal.id or hasAuthority('ADMIN')")
	public List<Recipe> listRecipes();
	
	public List<Recipe> matchRecipes(Set<String> inputIngredientNamesSet, int percentage);
	
	public List<Recipe> searchRecipe(String searchValue);
}
