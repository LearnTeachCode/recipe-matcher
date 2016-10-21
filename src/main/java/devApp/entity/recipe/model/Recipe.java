package devApp.entity.recipe.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Created by jonchin on 10/12/16.
 *
 * Recipe Class:
 * - Contains data for 1 recipe, including the name, a list of ingredients, the
 *   description of the recipe, and a list of instructions
 */
@Entity
@Table(name = "RECIPES")
public class Recipe {

    // instance variables
    private Integer key = null;                    // ? - don't remember what this was for...
    private String name = null;                // name of the recipe
    private Set<Ingredient> ingredients;   // an array of ingredients
    private String description = null;         // description of the recipe
   // private List<String> instructions;  // list of instructions
	
    @Id
    @GeneratedValue
    @Column(name = "RECIPE_ID")
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
	
	 @Column(name = "DESCRIPTION")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	
	//SPECIAL ANNOTATION
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	/*
	//special annotation
	public List<String> getInstructions() {
		return instructions;
	}
	
	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}
    */

}
