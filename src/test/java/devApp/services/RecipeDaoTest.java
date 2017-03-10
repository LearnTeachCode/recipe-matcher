package devApp.services;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import devApp.DevAppAbstractTest;
import devApp.entity.recipe.dao.RecipeDao;
import devApp.entity.recipe.model.Recipe;

@Transactional
public class RecipeDaoTest extends DevAppAbstractTest {

	@Autowired
	private RecipeDao recipeDao;

	@Test
	public void contextLoads() {
		assertThat(recipeDao, instanceOf(RecipeDao.class));
	}
	
	
	@Test 
	public void testSaveRecipe(){
		Recipe recipe = new Recipe();
		
		recipe.setName("Fish");
		recipe.setDescription("Soak shiitake mushrooms in 3/4 cup hot water...");
		
		//** save(recipe)
		this.recipeDao.save(recipe);
		
		Assert.assertNotNull("failure - saveRecipe: expected not null Recipe", recipe);
		Assert.assertEquals(recipe.getName(), "Fish");
	}
	
	
	@Test
	public void testGetRecipe(){
		Recipe recipe = new Recipe();
		recipe.setName("Fish");
		recipe.setDescription("Soak shiitake mushrooms in 3/4 cup hot water...");
				
		//** getRecipeById(int n)
		Assert.assertNotNull("failure - getRecipeById: expected not null Recipe", this.recipeDao.findOne(1));
		
		List<Recipe> listRecipes = (List<Recipe>) this.recipeDao.findAll();
		
		//** List<Recipe> listRecipes()
		Assert.assertNotNull("failure - listRecipes: expected not null WebUser", listRecipes.get(0));
		Assert.assertEquals("failure - expected size", 1, listRecipes.size());
	}
	
	
	@Test 
	public void testDeleteRecipe(){
		Recipe recipe = new Recipe();
		recipe.setKey(1);
		recipe.setName("Fish");
		recipe.setDescription("Soak shiitake mushrooms in 3/4 cup hot water...");
		
		Assert.assertNotNull("failure - expected not null", this.recipeDao.findOne(1));
		
		// remove the recipe
		this.recipeDao.delete(1);

		List<Recipe> listRecipe = (List<Recipe>) this.recipeDao.findAll();
				
		Assert.assertEquals("failure - expected size", 1, listRecipe.size());
		Assert.assertNull(this.recipeDao.findOne(1));
	}

    

}
