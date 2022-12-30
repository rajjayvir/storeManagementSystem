/**
 * CSCI 1110 Assignment 3
 * Author: Jayvirsinh Raj
 * <p>
 * Class Food
 * <p>
 * This assignment models a bakery with major classes Food, Baker and Bakery
 * <p>
 * This class Food is an abstract class that defines about the space, time, ingredients to bake etc.
 */
package Foods;

import Bakery.Ingredients;

import java.util.ArrayList;

public abstract class Food implements Comparable<Food> {

    /**
     * defines the name of the food, sell price, hours to bake, required hours, oven space required, the quantity made, and the ingredients to bake the food.
     */
    private final String name;
    private final double sellPrice;
    private final int hoursToBake;
    private final int requiredOvenSpace;
    protected Ingredients preferredIngredient;
    private int hoursBaking;
    private int quantityMade;

    /**
     * Constructor that defines th ename, sell price, hours to bake and required oven space.
     *
     * @param name        - defines the name of the item
     * @param sellPrice   - defines the price that is going to be sold at
     * @param hoursToBake - defines the hours that will be required for baking. initialised as 0
     * @param ovenSpace   - defines the total oven space. initialised as 0
     */
    public Food(String name, double sellPrice, int hoursToBake, int ovenSpace) {
        this.name = name;
        this.sellPrice = sellPrice;
        this.hoursToBake = hoursToBake;
        this.requiredOvenSpace = ovenSpace;
        this.hoursBaking = 0;
        this.quantityMade = 0;
    }

    /**
     * Is an abstract method
     *
     * @param ingredients - defines the total ingridents required
     * @return
     */
    public abstract double bake(ArrayList<Ingredients> ingredients);

    /**
     * getter for the name of food
     *
     * @return - name
     */
    public String getName() {
        return name;
    }

    /**
     * getter for the selling price
     *
     * @return - the selling price
     */
    public double getSellPrice() {
        return sellPrice;
    }

    /**
     * - total hours to bake the food
     * getter for the hours to bake
     *
     * @roturn - hours to bake the food
     */
    public int getHoursToBake() {
        return hoursToBake;
    }

    /**
     * getter for the hours required for baking
     *
     * @return - hours baking
     */
    public int getHoursBaking() {
        return hoursBaking;
    }

    /**
     * getter for the required oven space
     *
     * @return - required oven space for baking
     */
    public int getRequiredOvenSpace() {
        return requiredOvenSpace;
    }

    /**
     * getter for the quantity that is made
     *
     * @return - total quantity made
     */
    public int getQuantityMade() {
        return quantityMade;
    }

    /**
     * setter for the quantity made
     *
     * @param quantityMade - setts the quantity that is ready
     */
    public void setQuantityMade(int quantityMade) {
        this.quantityMade = quantityMade;
    }

    /**
     * getter for the preffered ingredients
     *
     * @return - the ingredients
     */
    public Ingredients getPreferredIngredient() {
        return preferredIngredient;
    }

    /**
     * This method adds an hour to the baking cycle
     * if the food is baked more that the food bake cycle it return 1.00
     *
     * @return - percentage of food's bake cycle
     */
    public double bake() {
        this.hoursBaking++;

        double bakeCycle = (double) hoursBaking / hoursToBake;

        if (bakeCycle > 1) {
            return 1.00;
        } else {
            return (bakeCycle * 100) / 100;
        }
    }

    /**
     * compare the food sell price with other one
     *
     * @param o - food that is to be compared
     * @return if sell price is equal that it returns 0 or returns -1 if greater and 1 of less
     */
    public int compareTo(Food o) {
        if (o.sellPrice == this.sellPrice) {
            return 0;
        } else if (this.sellPrice < o.sellPrice) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * prints the food details
     *
     * @return - String defining the food details
     */
    public String toString() {
        return String.format("%d %s (%s) - %d/%d hours", quantityMade, name, getPreferredIngredient().toString(), hoursBaking, hoursToBake);
    }
}


