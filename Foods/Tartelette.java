/**
 * CSCI 1110 Assignment 3
 * Author: Jayvirsinh Raj
 * <p>
 * Class Tartelette
 * <p>
 * This is a child class of the Pastry that defines the Tartelette type of the bakery
 */
package Foods;

import Bakery.Ingredients;

/**
 * defines the name(Tartelette), sell price, hours to bake and the hours baking for the Tartelette type of the cake
 * It also sets the preferred ingredient as Fig
 */
public class Tartelette extends Pastries {
    public Tartelette() {
        super("Tartelette", 7.24, 9, 2);
        this.preferredIngredient = Ingredients.Fig;
    }


}