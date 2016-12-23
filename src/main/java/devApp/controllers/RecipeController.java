package devApp.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import devApp.entity.recipe.model.Recipe;
import devApp.entity.recipe.service.RecipeServiceImpl;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	private static final Log LOG = LogFactory.getLog(RecipeController.class);
	
	@Autowired
	RecipeServiceImpl recipeServiceImpl;
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET, 
			produces={"application/json", "application/text"})
	@ResponseBody
	public String getRecipes(){
		
		final List<Recipe> recipeList = recipeServiceImpl.getAllRecipes();
		
		return recipeServiceImpl.getJsonList(recipeList, LOG, "recipes");
	}
	

}
