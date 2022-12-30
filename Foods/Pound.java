/**
 * CSCI 1110 Assignment 3
 * Author: Jayvirsinh Raj
 * <p>
 * Class Danish
 * <p>
 * This is a child class of the Cake that defines the Pound type of the bakery
 */
package Foods;

import Bakery.Ingredients;

public class Pound extends Cakes {

    /**
     * defines the name(Pound), sell price, hours to bake and the hours baking for the Pound type of the cake
     * It also sets the preferred ingredient as Lemon
     */
    public Pound() {
        super("PoundCake", 5.76, 2, 5);
        this.preferredIngredient = Ingredients.Lemon;

    }
}

