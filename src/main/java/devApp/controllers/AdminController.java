package devApp.controllers;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import devApp.entity.recipe.model.Ingredient;
import devApp.entity.recipe.model.Recipe;
import devApp.entity.recipe.service.RecipeService;
import devApp.entity.service.IngredientService;
import devApp.entity.user.model.WebUser;
import devApp.entity.user.service.WebUserService;
import devApp.helpers.AppHelper;
import devApp.security.util.SecurityRoleType;

@Controller
@RequestMapping("/manage")
public class AdminController {

	private static final Log LOG = LogFactory.getLog(AdminController.class);

	@Autowired
	private AppHelper appHelper;
	
	@Autowired
	private IngredientService ingService;
	
	@Autowired
	private RecipeService recService;
	
	@Autowired
	private WebUserService webUserService;
	
	
    @RequestMapping(value = {"/recipes-ingredients"}, method = RequestMethod.GET)
    public ModelAndView recipes() {
    	return new ModelAndView("recipes_ings");
    }
    
    @RequestMapping(value = {"/recipe-ingredients"}, method = RequestMethod.POST, produces={"application/json", "application/text"})
	@ResponseBody
    public String updateRecipeIngs(@RequestParam int recipe_id, @RequestParam String ingredients) {
    	Recipe recipe = this.recService.getRecipeById(recipe_id);
    	Set<Ingredient> newIngsSet = new HashSet<>();
    	
    	if(ingredients.length()>2){
    		String[] ingIdArray = ingredients.substring(1, ingredients.length()-1).split(",");
    		
	    	for(String stringIngId : ingIdArray){
	    		newIngsSet.add(this.ingService.getIngredientById(Integer.parseInt(stringIngId)));
	    	}
    	}

    	recipe.setIngredients(newIngsSet);
    	this.recService.saveRecipe(recipe);

    	return "1";
    }
    
    
    @RequestMapping(value = {"/ingredients"}, method = RequestMethod.GET)
    public ModelAndView ingredients(){
    	return new ModelAndView("ingredients");
    }

    @RequestMapping(value = {"/all/ingredients"}, method = RequestMethod.GET, produces={"application/json", "application/text"})
	@ResponseBody
	public String getIngredients(){
		final List<Ingredient> ingsList = this.ingService.listIngredients();

		return appHelper.getJsonList(ingsList, LOG, "ingredients");
	}
    
	@RequestMapping(value={"ingredient/add"})
	public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient){
		this.ingService.saveIngredient(ingredient);
		
		return "redirect:/manage/ingredients";
	}
     
	@RequestMapping(value={"ingredient/edit/{id}"}, method=RequestMethod.GET, produces={"application/json", "application/text"})
	@ResponseBody
	public String editRecipe(@PathVariable("id") int id){
		Ingredient ingredient = (Ingredient) this.ingService.getIngredientById(id);

		return this.appHelper.objectToJSON(ingredient, LOG, "ingredient");
	}

	@RequestMapping(value={"ingredient/remove/{id}"}, method=RequestMethod.GET)
	public String removeIngredients(@PathVariable("id") int id){
		this.ingService.deleteIngredient(id);

		return "redirect:/manage/ingredients";
	}
	
	
    @RequestMapping(value = {"/webusers"}, method = RequestMethod.GET)
    public String webUsers(Model model) {
    	String securityRoles = this.appHelper.objectToJSON(SecurityRoleType.values(), LOG, "SecurityRoles");
    	model.addAttribute("securityRoleTypes", securityRoles);
    	
    	return "webUsers";
    }
	
	@RequestMapping(value={"all/webUsers"}, method=RequestMethod.GET, produces={"application/json", "application/text"})
	@ResponseBody
	public String getAllWebUsers() {
		final List<WebUser> webUsersList = this.webUserService.getAllWebUsers();

		return appHelper.getJsonList(webUsersList, LOG, "webUsers");
	}
	
	@RequestMapping(value={"user/edit"}, method=RequestMethod.POST, produces={"application/json", "application/text"})
	@ResponseBody
	public String editWebUsers(String column, String editval, int id) throws Exception {
		WebUser webUser = this.webUserService.load((long) id);		
		
		String methodName = "set"+column;

		// calling setValue method by its name
		Method method = webUser.getClass().getDeclaredMethod(methodName, String.class);
		method.invoke(webUser, editval);

		this.webUserService.saveOrUpdate(webUser);
		
		return "1";
	}	
	
	
}
