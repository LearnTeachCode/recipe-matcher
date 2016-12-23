package devApp.entity.recipe.model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "RECIPES")
public class Recipe implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer key = null;                   
    private String name = null;               
   // private Set<Ingredient> ingredients = new HashSet<Ingredient>(); // an array of ingredients
	private String description = null; // description of the recipe
   // private List<String> instructions = new ArrayList<String>();  // list of instructions
    
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
	
	/*
    @ElementCollection
    @CollectionTable(name="INSTRUCTIONS", joinColumns=@JoinColumn(name="instruction_id"))
    public List<String> getInstructions() {
		return instructions;
	}

	public void setInstructions(List<String> instructions) {
		this.instructions = instructions;
	}

	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "Recipes_Ingredients", joinColumns = {
			@JoinColumn(name = "RECIPE_ID", nullable = false, updatable = false) },
			inverseJoinColumns = { @JoinColumn(name = "INGREDIENT_ID",
					nullable = false, updatable = false) })
	public Set<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(Set<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	*/
	

}
