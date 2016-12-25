package devApp.entity.recipe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import devApp.entity.recipe.dao.RecipeDao;
import devApp.entity.recipe.model.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeDao recipeDao;

    
    @Autowired
    @Qualifier(value="recipeDao")
	public void setRecipeDao(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}

	@Override
	@Transactional
	public void addRecipe(Recipe recipe) {
		this.recipeDao.addRecipe(recipe);
	}

	@Override
	@Transactional
	public void updateRecipe(Recipe recipe) {
		this.recipeDao.updateRecipe(recipe);
	}

	@Override
	@Transactional
	public void deleteRecipe(int id) {
		this.recipeDao.delteRecipe(id);
	}

	@Override
	@Transactional
	public Recipe getRecipeById(int id) {
		return this.recipeDao.getRecipeById(id);
	}

	@Override
	@Transactional
	public List<Recipe> listRecipes() {
		return this.recipeDao.listRecipes();
	}
	
}
