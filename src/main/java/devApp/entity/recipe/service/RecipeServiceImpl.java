package devApp.entity.recipe.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import devApp.entity.recipe.dao.RecipeDao;
import devApp.entity.recipe.model.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService{
	
    private static final Log LOG = LogFactory.getLog(RecipeServiceImpl.class);
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    
    @Autowired
    private RecipeDao recipeDao;
    
    public RecipeServiceImpl(){
    	super();
    }

	public RecipeServiceImpl(RecipeDao recipeDao) {
		this.recipeDao = recipeDao;
	}
    
	public List<Recipe> getAllRecipes(){
		
		return recipeDao.getAll();
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
    
    

}
