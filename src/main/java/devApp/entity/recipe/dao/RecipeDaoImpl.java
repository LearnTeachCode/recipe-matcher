package devApp.entity.recipe.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import devApp.entity.recipe.model.Recipe;

@Repository
public class RecipeDaoImpl implements RecipeDao{
	
	private SessionFactory sessionFactory;
	
	@Autowired
	@Qualifier("sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Recipe recipe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(recipe);
	}

	@Override
	public void update(Recipe recipe) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(recipe);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Recipe> listRecipes() {
		Session session = this.sessionFactory.getCurrentSession();		
		List<Recipe> recipeList = session.createQuery("from Recipe").list();
		//session.createCriteria(Recipe.class).list()
		
		return recipeList;
	}

	@Override
	public void delete(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Recipe recipe = (Recipe) session.load(Recipe.class, new Integer(id));
		
		if(recipe!=null){
			session.delete(recipe);
		}
	}

	@Override
	public Recipe getRecipeById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Recipe recipe = (Recipe) session.load(Recipe.class, new Integer(id));
		
		return recipe;
	}
	
}
