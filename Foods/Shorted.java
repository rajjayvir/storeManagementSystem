/**
 * CSCI 1110 Assignment 3
 * Author: Jayvirsinh Raj
 * <p>
 * Class Shorted
 * <p>
 * This is a child class of the Cake that defines the Shorted type of the bakery
 */
package Foods;


import Bakery.Ingredients;

public class Shorted extends Cakes {


    /**
     * defines the name(Shorted), sell price, hours to bake and the hours baking for the Shorted type of the cake
     * It also sets the preferred ingredient as Strawberries
     */
    public Shorted() {
        super("ShortedCake", 12.25, 5, 3);
        this.preferredIngredient = Ingredients.Strawberries;

    }
}