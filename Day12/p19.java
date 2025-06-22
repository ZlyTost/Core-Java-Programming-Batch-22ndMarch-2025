package Day12;

import java.util.ArrayList;
import java.util.List;

/*
 11. Recipe Management System

Description: A recipe management system that allows users to add recipes, 
view ingredients, and display cooking instructions.
 */
//Abstract class representing a Recipe
abstract class Recipe {
 protected String recipeName;
 protected List<String> ingredients;

 public Recipe(String recipeName) {
     this.recipeName = recipeName;
     this.ingredients = new ArrayList<>();
 }

 public abstract void addIngredient(String ingredient);
 public abstract void displayRecipe();
}

//Class representing a Simple Recipe
class SimpleRecipe extends Recipe {
 private String instructions;

 public SimpleRecipe(String recipeName, String instructions) {
     super(recipeName);
     this.instructions = instructions;
 }

 @Override
 public void addIngredient(String ingredient) {
     ingredients.add(ingredient);
     System.out.println("Added ingredient: " + ingredient);
 }

 @Override
 public void displayRecipe() {
     System.out.println("Recipe: " + recipeName);
     System.out.println("Ingredients: " + ingredients);
     System.out.println("Instructions: " + instructions);
 }
}

//Main class to test the Recipe Management System
public class p19 {
 public static void main(String[] args) {
     Recipe recipe = new SimpleRecipe("Pasta", "Boil water, add pasta, cook for 10 minutes.");
     recipe.addIngredient("Pasta");
     recipe.addIngredient("Salt");
     recipe.displayRecipe();
 }
}
