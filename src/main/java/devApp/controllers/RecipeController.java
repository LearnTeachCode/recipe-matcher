package devApp.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devApp.entity.recipe.model.Recipe;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public List<Recipe> getRecipe(){
		
		return null;
	}
	

}
