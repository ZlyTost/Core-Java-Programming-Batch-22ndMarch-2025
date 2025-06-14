package Day10;

import java.util.ArrayList;
import java.util.List;

/*
Recipe Management System: 
Design classes for Recipe, Ingredient, and User7. 
Implement methods for adding recipes and searching by ingredients.
*/

// Class representing an Ingredient
class Ingredient {
    private String name;
    private String quantity; // e.g., "2 cups", "1 tablespoon"

    public Ingredient(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }
}

// Class representing a Recipe
class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private String instructions;

    public Recipe(String name, String instructions) {
        this.name = name;
        this.ingredients = new ArrayList<>();
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public boolean containsIngredient(String ingredientName) {
        for (Ingredient ingredient : ingredients) {
            if (ingredient.getName().equalsIgnoreCase(ingredientName)) {
                return true;
            }
        }
        return false;
    }
}

// Class representing a User7
class User7 {
    private String User7name;
    private List<Recipe> recipes;

    public User7(String User7name) {
        this.User7name = User7name;
        this.recipes = new ArrayList<>();
    }

    public String getUser7name() {
        return User7name;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        System.out.println("Recipe added: " + recipe.getName());
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }
}

// Class for managing recipes
class RecipeManager {
    private List<Recipe> recipeList;

    public RecipeManager() {
        recipeList = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        recipeList.add(recipe);
        System.out.println("Recipe added to manager: " + recipe.getName());
    }

    public List<Recipe> searchByIngredient(String ingredientName) {
        List<Recipe> foundRecipes = new ArrayList<>();
        for (Recipe recipe : recipeList) {
            if (recipe.containsIngredient(ingredientName)) {
                foundRecipes.add(recipe);
            }
        }
        return foundRecipes;
    }
}

// Main class to run the Recipe Management System
public class p25 {
    public static void main(String[] args) {
        // Create a recipe manager
        RecipeManager recipeManager = new RecipeManager();

        // Create a User7
        User7 User7 = new User7("Alice");

        // Create recipes
        Recipe pancakeRecipe = new Recipe("Pancakes", "Mix ingredients and cook on a skillet.");
        pancakeRecipe.addIngredient(new Ingredient("Flour", "2 cups"));
        pancakeRecipe.addIngredient(new Ingredient("Milk", "1 cup"));
        pancakeRecipe.addIngredient(new Ingredient("Egg", "1"));

        Recipe omeletteRecipe = new Recipe("Omelette", "Beat eggs and cook in a pan.");
        omeletteRecipe.addIngredient(new Ingredient("Egg", "2"));
        omeletteRecipe.addIngredient(new Ingredient("Cheese", "1/2 cup"));
        omeletteRecipe.addIngredient(new Ingredient("Salt", "to taste"));

        // User7 adds recipes
        User7.addRecipe(pancakeRecipe);
        User7.addRecipe(omeletteRecipe);

        // Add recipes to the recipe manager
        recipeManager.addRecipe(pancakeRecipe);
        recipeManager.addRecipe(omeletteRecipe);

        // Search for recipes by ingredient
        String searchIngredient = "Egg";
        List<Recipe> foundRecipes = recipeManager.searchByIngredient(searchIngredient);
        System.out.println("Recipes containing " + searchIngredient + ":");
        for (Recipe recipe : foundRecipes) {
            System.out.println(recipe.getName());
        }
    }
}
