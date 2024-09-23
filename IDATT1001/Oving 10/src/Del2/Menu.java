package Del2;

import java.util.ArrayList;

/**
 * A class that holds a list of dishes in a menu and the name of the restaurant
 */
public class Menu {
    private final ArrayList<Dish> menu;
    private final String restaurantName;

    /**
     * Initializes a Menu object
     * @param menu              list of dishes
     * @param restaurantName    Name of restaurant
     */
    Menu(ArrayList<Dish> menu, String restaurantName){this.menu = menu; this.restaurantName = restaurantName;}

    /**
     * Gets the list of dishes(menu)
     * @return a deep copy of the list of dishes
     */
    public ArrayList<Dish> getMenu(){
        return new ArrayList<>(menu);
        }

    /**
     * Get the name of the restaurant
     * @return name of restaurant
     */
    public String getRestaurantName(){return restaurantName;}

    /**
     * Adds a dish to the list of dished(menu)
     * @param dish dish to be added
     */
    public void addDish(Dish dish){menu.add(dish);}

    /**
     * Finds the total price of the list of dishes(menu)
     * @return  total price of menu
     */
    public int findTotalPrice(){
        int totalPrice = 0;
        for (int i = 0; i < menu.size(); i++){
            totalPrice += menu.get(i).getPrice();
        }
        return totalPrice;
    }

    /**
     * Overrides the toString method to let us print Menu objects directly
     * @return  menu as string
     */
    public String toString(){
        return restaurantName + " : " + menu.toString();
    }

}
