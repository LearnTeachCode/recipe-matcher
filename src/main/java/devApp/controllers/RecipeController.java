package devApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import devApp.entity.recipe.model.Recipe;
import devApp.entity.recipe.service.RecipeService;

@Controller
//@RequestMapping("/recipe")
public class RecipeController {
	
	// private static final Log LOG = LogFactory.getLog(RecipeController.class);
	
	private RecipeService recipeService;
	
	@Autowired
	@Qualifier(value="recipeService")
	public void getRecipeService(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	
	/*
	@RequestMapping(value = {"/"}, method = RequestMethod.GET, 
			produces={"application/json", "application/text"})
	@ResponseBody
	public String getRecipes(){		
		final List<Recipe> recipeList = recipeServiceImpl.getAllRecipes();
		
		return recipeServiceImpl.getJsonList(recipeList, LOG, "recipes");
	}
	*/


	@RequestMapping(name="/recipes", method=RequestMethod.GET)
	public String recipes(Model model){
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("recipeList", this.recipeService.listRecipes());
		
		return "recipes";
	}
	
	
	@RequestMapping("/recipes/add")
	public String addRecipe(@ModelAttribute("recipe") Recipe recipe){
		if(recipe.getId()==0){
			this.recipeService.add(recipe);
		} else {
			this.recipeService.update(recipe);
		}
		
		return "redirect:/recipes";
	}
	
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable("id") int id, Model model){
		model.addAttribute("recipe", this.recipeService.getRecipeById(id));
		model.addAttribute("recipeList", this.recipeService.listRecipes());
		
		return "recipes";
	}
	
	
	@RequestMapping("/remove/{id}")
	public String remove(@PathVariable("id") int id){
		this.recipeService.delete(id);
		
		return "redirect:/recipes";
	}
	
	
	@RequestMapping("/recipedata/{id}")
	public String recipeData(@PathVariable("id") int id, Model model){
		model.addAttribute("recipe", this.recipeService.getRecipeById(id));
		return "recipedata";
	}

}
