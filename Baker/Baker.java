/**
 * CSCI 1110 Assignment 3
 * Author: Jayvirsinh Raj
 * <p>
 * This is the Baker class of the assignment
 * <p>
 * Baker has a name and can own a bakery
 */
package Baker;

import Bakery.Bakery;
import Foods.Food;

import java.util.ArrayList;

public class Baker {

    /**
     * deinses the name of the baker
     * money that baker have
     * and if the baker owns a bakery that it defines that
     */
    private String name;
    private double money;
    private Bakery bakery;

    /**
     * constructor class that initialises the money that baker has to 1000
     *
     * @param name - the name of the baker
     */
    public Baker(String name) {
        this.name = name;
        this.money = 1000;
    }

    /**
     * constructor class that initialises the money that baker has to 1000
     *
     * @param name   - name of the baker
     * @param bakery - bakery owned by the baker
     */
    public Baker(String name, Bakery bakery) {
        this.name = name;
        this.money = 1000;
        this.bakery = bakery;
    }

    /**
     * @param i index of teh array bakery
     * @return -the bakery at the index i
     */
    public Food getFoodFromBakery(int i) {
        return bakery.getFoods().get(i);
    }

    /**
     * @return name of the baker
     */
    public String getName() {
        return name;
    }

    /**
     * @return the money that the baker have
     */
    public double getMoney() {
        return money;
    }

    /**
     * running the oven one-hour costs 10 CAD.
     * Only, if the baker has enough money, the bakery can bake the food one extra hour.
     * calculates the money according to the hours that it is going to be baked
     */
    public void waitOneHour() {
        ArrayList<Food> a = bakery.getFoods();

        double cost = 0;

        for (Food i : a) {
            cost *= 10;
        }
        if (money >= 10) {
            bakery.addHour();
            ;
            money -= 10;
        }
    }

    /**
     * bakers can bake food on the bakery (assuming they own one) if they have enough money for the quantity they want to make.
     *
     * @param quantity - quantity of teh food that
     * @param food-    food that is going to be prepared
     * @return - a boolean if the food is going to be made
     */
    public boolean makeFood(int quantity, Food food) {

        double total = 0;

        if (money >= quantity * food.getSellPrice() && bakery != null && quantity <= bakery.getTotalOvenSpace()) {

            bakery.bakeFood(quantity, food);
            if (food.getName().equals("Danish") || food.getName().equals("Tartelette")) {

                money -= quantity * 23.00;
            }
            if (food.getName().equals("ShortedCake") || food.getName().equals("PoundCake")) {
                money -= quantity * 15.00;
            }
            return true;
        } else {
            return false;
        }
    }

    /**
     * add the selling value to the money that baker have
     */
    public void sellFood() {
        money += bakery.getReadyToSellValue();
    }

    /**
     * Buys a bakery if the baker does not have one
     *
     * @param bakery - bakery that baker is going to buy
     * @return - boolean weather or not the baker is going to buy or not
     */
    public boolean buyBakery(Bakery bakery) {

        if (this.bakery == null) {

            this.bakery = bakery;
            return true;
        }
        return false;
    }


    /**
     * @return the output as per the condition
     */
    public String toString() {

        String output = "Baker: " + name + "\nMoney left: " + String.format("%.2f", money);

        if (!(bakery == null)) {
            return output += "Bakery info:\n" + bakery;
        } else {
            return output += name + " owns no bakery";
        }
    }


}