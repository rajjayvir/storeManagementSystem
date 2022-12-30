/**
 * CSCI 1110 Assignment 3
 * Author: Jayvirsinh Raj
 * <p>
 * Class Danish
 * <p>
 * This is a child class of the Pastry that defines the danish type of the bakery
 */
package Foods;

import Bakery.Ingredients;

/**
 * defines the name(Danish), sell price, hours to bake and the hours baking for the danish type of the cake
 * It also sets the preferred ingredient as Chocolate
 */
public class Danish extends Pastries {
    public Danish() {
        super("Danish", 2.34, 3, 6);
        this.preferredIngredient = Ingredients.Chocolate;

    }
}