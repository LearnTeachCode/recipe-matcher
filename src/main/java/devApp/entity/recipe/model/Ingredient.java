package devApp.entity.recipe.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "INGREDIENTS")
@Proxy(lazy=false)
@Access(AccessType.PROPERTY)
public class Ingredient implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer key = null;
	private String name = null;
	private String description = null;
	private Set<Recipe> recipes = new HashSet<Recipe>();
	//private List<IngredientDetail> ingredients;
	
	@Id
	@GeneratedValue
	@Column(name = "INGREDIENT_ID")
	public Integer getKey() {
		return key;
	}
	
	public void setKey(Integer key) {
		this.key = key;
	}
	
	@Column(name = "NAME")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name ="DESCRIPTION")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}


	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "ingredients")
	//@ElementCollection(targetClass=Recipe.class)
	@JsonBackReference
	public Set<Recipe> getRecipes() {
		return recipes;
	}
	
	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}

}
