package devApp.entity.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devApp.entity.dao.IngredientDao;
import devApp.entity.recipe.model.Ingredient;

@Service
public class IngredientServiceImpl implements IngredientService {

	@Autowired
	private IngredientDao ingredientDao;

	@Override
	@Transactional
	public void saveIngredient(Ingredient ingredient) {
		this.ingredientDao.save(ingredient);
	}

	@Override
	@Transactional
	public void deleteIngredient(int id) {
		this.ingredientDao.delete(id);
	}

	@Override
	@Transactional
	public Ingredient getIngredientById(int id) {
		return this.ingredientDao.findOne(id);
	}

	@Override
	@Transactional
	public List<Ingredient> listIngredients() {
		return (List<Ingredient>) this.ingredientDao.findAll();
	}
	
}
