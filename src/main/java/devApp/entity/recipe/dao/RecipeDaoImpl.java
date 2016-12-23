package devApp.entity.recipe.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import devApp.data.GenericSimpleAbstractDao;
import devApp.entity.recipe.model.Recipe;

public class RecipeDaoImpl extends GenericSimpleAbstractDao<Recipe> implements RecipeDao{

	private static final Log LOG = LogFactory.getLog(RecipeDaoImpl.class);
	
	@Override
	public Class<Recipe> getEntityClass() {
		return Recipe.class;
	}
	
    public RecipeDaoImpl(SessionFactory sessionFactory) {
        this.setSessionFactory(sessionFactory);
    }
    
    /**
     * Create 
     * 
     * Update
     */
    @Override
    public Recipe saveOrUpdate(Recipe recipe) {
        try {
            return this.save(recipe);
        } catch (Exception e) {
            if (LOG.isErrorEnabled()) {
                LOG.error(e.getMessage(), e);
            }
            return null;
        }
    }
    
    /**
     * Read
     */
    @Override
    public List getAll() {
        final Session session =
                this.getSessionFactory().getCurrentSession();
        Criteria crit =
                session.createCriteria(Recipe.class);
        return crit.list();
    }
    
    /**
     * Delete
     */
    public void delete(Integer key) {
    	
    	final Session session =
                this.getSessionFactory().getCurrentSession();
    	
    	Recipe recipe = (Recipe ) session.createCriteria(Recipe.class)
                .add(Restrictions.eq("key", key)).uniqueResult();
    	session.delete(recipe);

    }

	
}
