package devApp.controllers;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import devApp.entity.recipe.model.Recipe;
import devApp.entity.recipe.service.RecipeService;
import devApp.entity.user.model.WebUser;
import devApp.helpers.AppHelper;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	private static final Log LOG = LogFactory.getLog(RecipeController.class);
	
	@Autowired
	private AppHelper appHelper;
		
	@Autowired
	private RecipeService recipeService;
	
	@RequestMapping(value = {"/all"}, method = RequestMethod.GET, produces={"application/json", "application/text"})
	@ResponseBody
	public String getRecipes(){
		final List<Recipe> recipeList = recipeService.listRecipes();
		
		return appHelper.getJsonList(recipeList, LOG, "recipes");
	}
	
	@RequestMapping(value={"/add"})
	public String addRecipe(@ModelAttribute("recipe") Recipe recipe){
		if(recipe.getKey()!=0){
			Recipe exRecipe = this.recipeService.getRecipeById(recipe.getKey());
			
			recipe.setIngredients(exRecipe.getIngredients());
			recipe.setOwner(exRecipe.getOwner());
			recipe.setIsNew(exRecipe.isIsNew());
		} else {		
			/* Setting recipe owner */
			WebUser webUser = (WebUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();		
			recipe.setOwner(webUser.getId());
		}
		
		this.recipeService.saveRecipe(recipe);
		
		return "redirect:/recipes";
	}
	
	@RequestMapping(value={"/remove/{id}"}, method=RequestMethod.GET)
	public String removeRecipe(@PathVariable("id") int id){	
		this.recipeService.deleteRecipe(this.recipeService.getRecipeById(id));
		
		return "redirect:/recipes";
	}
	
	@RequestMapping(value={"/edit/{id}"}, method=RequestMethod.GET, produces={"application/json", "application/text"})
	@ResponseBody
	public String editRecipe(@PathVariable("id") int id){
		Recipe recipe = (Recipe) this.recipeService.getRecipeById(id);

		return this.appHelper.objectToJSON(recipe, LOG, "recipe");
	}
	
	
	@RequestMapping(value={"/{id}"})
	public String recipeInfo(@PathVariable("id") int id, Model model){
		Recipe recipe = (Recipe) this.recipeService.getRecipeById(id);
		model.addAttribute("recipejson", this.appHelper.objectToJSON(recipe, LOG, "recipe"));	
		
		return "recipedata";
	}
	
	
	@RequestMapping(value={"/makeOld"}, method=RequestMethod.POST, produces={"application/json", "application/text"})
	@ResponseBody
	public String makeOld(@RequestParam(value="idArray[]") String[] idArray){
		for(String recipe_id : idArray){		
			Recipe recipe = this.recipeService.getRecipeById(Integer.parseInt(recipe_id));
    		recipe.setIsNew(false);
    		
    		this.recipeService.saveRecipe(recipe);
    	}
		
    	return "1";
    }
	
}
