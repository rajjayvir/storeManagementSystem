/**
 * CSCI 1110 Assignment 3
 * Author: Jayvirsinh Raj
 * <p>
 * Class Cakes
 * <p>
 * This is a child class of the food that have details about the cake
 * it inherits and overrides many method from the food class
 */
package Foods;

import Bakery.Ingredients;

import java.util.ArrayList;

public class Cakes extends Food {

    int skipHOURS = 1;

    /**
     * constructor class
     * sets the preferred ingredient as Flour
     * @param name - defines the name the class
     * @param sellPrice defines the sell price
     * @param hoursToBake - defines the hours to bake
     * @param hoursBaking - defies the hours baking
     */
    public Cakes(String name, double sellPrice, int hoursToBake, int hoursBaking) {
        super(name, sellPrice, hoursToBake, hoursBaking);
        preferredIngredient = Ingredients.Flour;
    }

    @Override
    /**
     * overrides the bake method from its parent class Food
     * check the preferred ingredients and skips hours as per the condition
     */ public double bake(ArrayList<Ingredients> ingredients) {
        if (ingredients.contains(preferredIngredient)) {
            return bake();
        } else {
            if (skipHOURS == 0) {
                skipHOURS++;
                return bake();
            } else {
                skipHOURS--;
                return 0;
            }
        }
    }

}


