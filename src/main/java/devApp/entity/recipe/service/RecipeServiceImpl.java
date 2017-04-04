package devApp.entity.recipe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devApp.entity.recipe.dao.RecipeDao;
import devApp.entity.recipe.model.Ingredient;
import devApp.entity.recipe.model.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService {

	@Autowired
	private RecipeDao recipeDao;

	@Override
	@Transactional
	public void saveRecipe(Recipe recipe) {
		this.recipeDao.save(recipe);
	}


	@Override
	@Transactional
	public void deleteRecipe(Recipe recipe) {
		this.recipeDao.delete(recipe);
	}

	@Override
	@Transactional
	public Recipe getRecipeById(int id) {
		return this.recipeDao.findOne(id);
	}

	@Override
	@Transactional
	public List<Recipe> listRecipes() {
		return (List<Recipe>) this.recipeDao.findAllByOrderByIsNewDescKeyDesc();
	}

	@Override
	@Transactional
	public List<Recipe> matchRecipes(Set<String> inputIngredientNamesSet, int percentage) {
		if(percentage<50) percentage = 50;
		
		List<Recipe> matchedRecipes = new ArrayList<>();

		recipe_loop: for(Recipe exist_recipe : this.recipeDao.findAllByIsEnabled(true)){
			Set<Ingredient> ingredients = exist_recipe.getIngredients();
			
			if(inputIngredientNamesSet.size() < ingredients.size()*percentage/100) 
				continue;
			
			int notInPercentage = 0;
			
			for(Ingredient ing : ingredients){				
				String s = ing.getName();
				
				if(!inputIngredientNamesSet.contains(s.toLowerCase())){
					notInPercentage+=(100/ingredients.size());
					if(notInPercentage>100-percentage) 
						continue recipe_loop;					
				}
			}

			matchedRecipes.add(exist_recipe);
		}
		
		return matchedRecipes;
	}
	
}
