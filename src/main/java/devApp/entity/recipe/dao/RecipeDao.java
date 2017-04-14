package devApp.entity.recipe.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import devApp.entity.recipe.model.Recipe;

@Repository
public interface RecipeDao extends CrudRepository<Recipe, Integer> {

	public List<Recipe> findAllByOrderByIsNewDescKeyDesc();
	
	public List<Recipe> findAllByIsEnabled(Boolean enabled);
	
	@Query("FROM Recipe r WHERE (r.name LIKE %:value% OR r.description LIKE %:value%) AND r.isEnabled=1")
	public List<Recipe> findByNameAndDescription(@Param("value") String searchValue);
}
