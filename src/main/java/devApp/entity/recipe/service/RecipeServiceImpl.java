package devApp.entity.recipe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devApp.entity.recipe.dao.RecipeRepository;
import devApp.entity.recipe.model.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeRepository recipeRepository;

	@Override
	@Transactional
	public void saveRecipe(Recipe recipe) {
		this.recipeRepository.save(recipe);
	}


	@Override
	@Transactional
	public void deleteRecipe(int id) {
		this.recipeRepository.delete(id);
	}

	@Override
	@Transactional
	public Recipe getRecipeById(int id) {
		return this.recipeRepository.findOne(id);
	}

	@Override
	@Transactional
	public List<Recipe> listRecipes() {
		return (List<Recipe>) this.recipeRepository.findAll();
	}
	
}
