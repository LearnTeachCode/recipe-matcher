package devApp.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import devApp.entity.recipe.model.Recipe;
import devApp.entity.recipe.service.RecipeService;
import devApp.helpers.AppHelper;


@Controller
public class PublicController {

	private static final Log LOG = LogFactory.getLog(PublicController.class);
	
	@Autowired
	private RecipeService recService;
	
	@Autowired
	private AppHelper appHelper;

	
    @RequestMapping(value={"/match"}, method=RequestMethod.GET)
    public String getMatchRecipe(Model model){
    	model.addAttribute("matchedList", "''");
    	
    	return "matchRecipe";
    }
    
    @RequestMapping(value={"/match"}, method=RequestMethod.POST)
    public String matchRecipe(Model model, @RequestParam(value="ingredients[]") String[] ingsArray, @RequestParam(value="percentage") int percentage){
    	Set<String> inputIngsSet = new HashSet<String>(Arrays.asList(ingsArray));

    	List<Recipe> matchedList = this.recService.matchRecipes(inputIngsSet, percentage);    	
    	String jsonMatchedRecipes = this.appHelper.getJsonList(matchedList, LOG, "recipes");

    	model.addAttribute("matchedList", jsonMatchedRecipes);
    	
    	return "matchRecipe";
    }
        
    @RequestMapping(value={"/search"}, method=RequestMethod.GET)
    public String getMatchRecipe(Model model, @RequestParam(value="q") String searchValue){
    	List<Recipe> matchedList = this.recService.searchRecipe(searchValue.trim());
    	String jsonMatchedRecipes = this.appHelper.getJsonList(matchedList, LOG, "recipes");
    	
    	model.addAttribute("matchedList", jsonMatchedRecipes);
    	
    	return "matchRecipe";
    }
}
