package devApp.entity.recipe.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import devApp.entity.recipe.model.Recipe;

@Repository
@Transactional
public interface RecipeDao {

	Recipe saveOrUpdate(Recipe recipe);
	
	List<Recipe> getAll();

	void delete(Integer key);

}
