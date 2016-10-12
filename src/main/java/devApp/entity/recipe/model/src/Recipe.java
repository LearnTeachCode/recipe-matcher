import java.util.List;

/**
 * Created by jonchin on 10/12/16.
 *
 * Recipe Class:
 * - Contains data for 1 recipe, including the name, a list of ingredients, the
 *   description of the recipe, and a list of instructions
 */
public class Recipe {

    // instance variables
    private int key;                    // ? - don't remember what this was for...
    private String name;                // name of the recipe
    private Ingredient[] ingredients;   // an array of ingredients
    private String description;         // description of the recipe
    private List<String> instructions;  // list of instructions


    // methods

    /*
     * Sorts the ingredients inputted by the user
     * Input: Ingredient[] ingredients
     * Output: Ingredient[] ingredients // FIXME: change later
     * Side effects: none
     */
    public Ingredient[] sortIngredients(Ingredient[] ingredients) {

        return ingredients; // FIXME: change later
    }


}
