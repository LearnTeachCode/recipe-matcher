package devApp.entity.recipe.model;
import java.io.Serializable;

import javax.persistence.*;
import org.hibernate.annotations.Proxy;

@Entity
@Table(name = "RECIPES")
@Proxy(lazy=false)
public class Recipe implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "RECIPE_ID")
	private int key;  
	
	@Column(name = "NAME")
    private String name;               
    
	@Column(name = "DESCRIPTION")
	private String description;
	
	// private Set<Ingredient> ingredients = new HashSet<Ingredient>(); // an array of ingredients	
    // private List<String> instructions = new ArrayList<String>();  // list of instructions
    
    
    public int getKey() {
		return key;
	}
    
	public void setKey(int key) {
		this.key = key;
	}
	
	 
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Recipe [key=" + key + ", name=" + name + ", description=" + description + "]";
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
