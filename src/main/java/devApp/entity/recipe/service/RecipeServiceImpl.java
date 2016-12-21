package devApp.entity.recipe.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import devApp.entity.recipe.dao.RecipeDao;
import devApp.entity.recipe.model.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService{
	
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    
    private RecipeDao recipeDao;

    @Autowired
    @Qualifier("recipeDao")
	public void setRecipeDao(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}

    
	public String getJsonList(List<Recipe> recipes, Log LOG, String processType){
		
		if(LOG.isInfoEnabled()){
			LOG.info((CollectionUtils.isEmpty(recipes)
					? "[null/empty]" : recipes.size())
					+ " " + processType + "loaded");
		}
		
		final List<String> jsonList = new ArrayList<>();
		
		for(Recipe r : recipes){
			
			try {
				
				final String processed = OBJECT_MAPPER.writeValueAsString(r);
				jsonList.add(processed);
				
			} catch (JsonProcessingException e) {
				
				if(LOG.isErrorEnabled())
					LOG.error(e.getMessage());
				e.printStackTrace();
			}
			
			
		}
		
		return jsonList.toString();
	}

	
	@Override
	@Transactional
	public void add(Recipe recipe) {
		this.recipeDao.add(recipe);
	}

	
	@Override
	@Transactional
	public void update(Recipe recipe) {
		this.recipeDao.update(recipe);
	}


	@Override
	@Transactional
	public void delete(int id) {
		this.recipeDao.delete(id);
	}


	@Override
	@Transactional
	public List<Recipe> listRecipes() {
		return this.recipeDao.listRecipes();
	}


	@Override
	@Transactional
	public Recipe getRecipeById(int id) {
		return this.recipeDao.getRecipeById(id);
	}

}
