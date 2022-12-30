/**
 * CSCI 1110 Assignment 3
 * Author: Jayvirsinh Raj
 * <p>
 * Class Pastries
 * <p>
 * This is a child class of the food that have details about the Pastries
 * it inherits and overrides many method from the food class
 */
package Foods;

import Bakery.Ingredients;

import java.util.ArrayList;

public class Pastries extends Food {

    //hours to skip for the bakery
    int skipHOURS = 2;

    /**
     * Constructor class
     *
     * @param name        - name of the pastry
     * @param sellPrice   - selling price of the pastry
     * @param hoursToBake - hours required to bake the pastry
     * @param OvenSpace   - oven space required to bake the bakery
     */
    public Pastries(String name, double sellPrice, int hoursToBake, int OvenSpace) {
        super(name, sellPrice, hoursToBake, OvenSpace);
        preferredIngredient = Ingredients.Pastry;

    }

    @Override
    /**
     * OVerides the bake method from the parent class
     * @param ingredients - defines the total ingredients required
     * @return - percentage of food's bake cycle
     */ public double bake(ArrayList<Ingredients> ingredients) {
        if (ingredients.contains(preferredIngredient)) {
            return bake();
        } else {
            if (skipHOURS == 0) {
                skipHOURS += 2;
                return bake();
            } else {
                skipHOURS--;
                return 0;
            }
        }
    }

}