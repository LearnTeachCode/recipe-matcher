package devApp.entity.recipe.model;

import devApp.data.GenericSimpleAbstractDao;
import devApp.entity.user.dao.WebUserDao;
import devApp.entity.user.model.WebUser;

public class RecipeDaoImpl extends GenericSimpleAbstractDao<Recipe> implements RecipeDao {

	@Override
	public Class<Recipe> getEntityClass() {
		return Recipe.class;
	}

	
	
}
