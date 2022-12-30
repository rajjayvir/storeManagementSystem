/**
 * CSCI 1110 Assignment 3
 * Author: Jayvirsinh Raj
 * <p>
 * THis is the Danish Bakery class of the assignment.
 * <p>
 * This is a child class of the Bakery Class
 */
package Bakery;

import Foods.Food;

import java.util.ArrayList;

public class DanishBakery extends Bakery {

    /**
     * constructor class that is inherited from the bakery class
     *
     * @param totalOvenSpace - space in the oven
     */
    public DanishBakery(int totalOvenSpace) {

        super(totalOvenSpace);

        ArrayList<Ingredients> ing = new ArrayList<Ingredients>();

        ing.add(Ingredients.Chocolate);
        ing.add(Ingredients.Fig);
        ing.add(Ingredients.Pastry);

    }

    /**
     * Has almost same function as the Bakefood in the Bakery class but here it analysis for the Danish Bakery
     *
     * @param quantity
     * @param a        - arraylist food that will add the food
     * @return boolean true if it is Danish
     */
    public boolean bakeFood(int quantity, Food a) {

        return a.getName().equals("Danish");


    }
}