/**
 * CSCI 1110 Assignment 3
 * Author: Jayvirsinh Raj
 * <p>
 * THis is the Bakery class of the assignment.
 * <p>
 * Bakeries can hold different types of food if they have enough space in the oven for each food.
 * In addition to it, this class holds the information of the food, and the bakery ingredients.
 */
package Bakery;

import Foods.Food;

import java.util.ArrayList;

public class Bakery {

    //defines the total oven space, arraylist of food and the bakery ingredients
    private int totalOvenSpace;
    private ArrayList<Food> foods;
    private ArrayList<Ingredients> bakeryIngredients;

    /**
     * cnstructor class
     *
     * @param totalOvenSpace total available oven space
     */
    public Bakery(int totalOvenSpace) {
        this.totalOvenSpace = totalOvenSpace;
    }

    /**
     * constructor class
     *
     * @param totalOvenSpace    total available oven space
     * @param bakeryIngredients - ingredients required for baking
     */
    public Bakery(int totalOvenSpace, ArrayList<Ingredients> bakeryIngredients) {
        this.totalOvenSpace = totalOvenSpace;
        this.bakeryIngredients = bakeryIngredients;
        foods = new ArrayList<>();
    }

    /**
     * getter for total oven space
     *
     * @return total available oven space
     */
    public int getTotalOvenSpace() {
        return totalOvenSpace;
    }

    /**
     * getter for food required
     *
     * @return - the food in the arraylist
     */
    public ArrayList<Food> getFoods() {
        return foods;
    }

    /**
     * getter for teh food ingredients
     *
     * @return - the required ingredients
     */
    public ArrayList<Ingredients> getBakeryIngredients() {
        return bakeryIngredients;
    }

    /**
     * get the food from the arraylist
     *
     * @param index - indes of the arraylist
     * @return null if the index is invalid or else it will return the food at the given index
     */
    public Food getFood(int index) {
        if (index >= foods.size()) {
            return null;
        } else {
            return foods.get(index);
        }
    }

    /**
     * @return the size of the food arraylist
     */
    public int getFoodQuantity() {
        return foods.size();
    }

    /**
     * computes the total bakery value combining the selling price of all the foods in the oven.
     *
     * @return - the total cost of the food in the oven
     */
    public double getTotalBakeryValue() {

        double totalCost = 0;
        for (int i = 0; i < foods.size(); i++) {
            totalCost += foods.get(i).getSellPrice() * foods.get(i).getQuantityMade();
        }
        return totalCost;
    }

    /**
     * computes the bakery value only considering the foods that are ready to take off the oven.
     *
     * @return - the total value as per the food that is ready to be taken off the oven
     */
    public double getReadyToSellValue() {
        double totalCost = 0;

        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getHoursToBake() <= foods.get(i).getHoursBaking()) {
                totalCost += foods.get(i).getQuantityMade() * foods.get(i).getSellPrice();
            }
        }
        return totalCost;
    }

    /**
     * Tries to put the given quantity of food in the oven.
     * If the bakery does not have enough oven space left for the new food, return false and do not add the food to the oven.
     * If the bakery has enough space, add the food to the oven and return true.
     *
     * @param foodQuantity - food that is put in the oven
     * @param a            - arraylist food that will add the food
     * @return - boolean as per the condition
     */
    public boolean bakeFood(int foodQuantity, Food a) {

        int totalSize = 0;

        for (int i = 0; i < foods.size(); i++) {
            totalSize += foods.get(i).getQuantityMade() * foods.get(i).getRequiredOvenSpace();
        }
        totalSize += a.getRequiredOvenSpace() * foodQuantity;


        if (totalOvenSpace < totalSize) {
            return false;
        } else {
            //add food to the oven
            a.setQuantityMade(foodQuantity);
            foods.add(a);
            return true;
        }
    }

    /**
     * tries to take the food at the int index from the oven.
     * Foods can only be taken from the oven if the time since they are in is greater or equal than the time they need to bake.
     * If the food is taken of the oven, the method removes it from the oven and return the food object.
     *
     * @param index- index of the arraylist food in the oven
     * @return - the index of the food that is to be removed
     */
    public Food takeFoodOfOven(int index) {

        if (foods.get(index).getHoursBaking() >= foods.get(index).getHoursToBake()) {
            return foods.remove(index);
        } else {
            return null;
        }
    }

    /**
     * iterates over all the food in the oven and hour is added to the bake cycle
     */
    public void addHour() {
        for (int i = 0; i < foods.size(); i++) {
            foods.get(i).bake(bakeryIngredients);
        }
    }

    /**
     * @return the output as per the problem
     */
    public String toString() {

        String print = "";
        String printFood = "";
        for (int i = 0; i < foods.size(); i++) {
            print += i + " - " + foods.get(i).toString();
            if (i < foods.size() - 1) {
                print += "\n";
            }
        }

        if (print.equals("")) {
            printFood = "No food available";
        } else {
            printFood = "Food available:";
        }

        return String.format("Total bakery Value: %.2f\nReady to sell value: %.2f\n%s\n%s", getTotalBakeryValue(), getReadyToSellValue(), printFood, print);

    }

}
