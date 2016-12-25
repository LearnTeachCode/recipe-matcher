package devApp.entity.recipe.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import devApp.data.GenericSimpleAbstractDao;
import devApp.entity.recipe.model.Recipe;

@Repository
public class RecipeDaoImpl extends GenericSimpleAbstractDao<Recipe> implements RecipeDao{

	private static final Log LOG = LogFactory.getLog(RecipeDaoImpl.class);
	
	private SessionFactory sessionFacotry;
	
	@Autowired
	@Qualifier("sessionFactory")
    public void setSessionFacotry(SessionFactory sessionFactory) {
        this.sessionFacotry = sessionFactory;
    }
	
	@Override
	public Class<Recipe> getEntityClass() {
		return Recipe.class;
	}


	@Override
	public void addRecipe(Recipe recipe) {
		Session session = this.sessionFacotry.getCurrentSession();
		session.persist(recipe);		
		
		LOG.info("The recipe added successfully. Recipe info: "+ recipe);
	}

	@Override
	public void updateRecipe(Recipe recipe) {
		Session session = this.sessionFacotry.getCurrentSession();
		session.update(recipe);		
		
		LOG.info("The recipe updated successfully. Recipe info: "+ recipe);
	}

	@Override
	public void delteRecipe(int id) {
		Session session = this.sessionFacotry.getCurrentSession();		
		Recipe recipe = (Recipe) session.load(getEntityClass(), new Integer(id));
		
		if(recipe!=null){
			session.delete(recipe);
			LOG.info("The recipe deleted successfully. Recipe info: "+ recipe);
		}	
	}

	@Override
	public Recipe getRecipeById(int id) {
		Session session = this.sessionFacotry.getCurrentSession();
		Recipe recipe = (Recipe) session.load(getEntityClass(), new Integer(id));
		
		LOG.info("The recipe returned successfully. Recipe info: "+ recipe);
		return recipe;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Recipe> listRecipes() {
		Session session = this.sessionFacotry.getCurrentSession();		
		List<Recipe> listRecipes = session.createQuery("from Recipe").list();
		
		for(Recipe recipe: listRecipes){
			LOG.info("The recipe listed successfully. Recipe info: "+ recipe);
		}
		
		return listRecipes;
	}
    
 
   
	
}
