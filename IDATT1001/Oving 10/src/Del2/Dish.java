package Del2;

/**
 * A class that hold all the necessary information for a dish
 */
public class Dish {
    private final String name;
    private final String type;
    private final int price;

    /**
     * Constructor that initializes a object of the dish class
     * @param name  name of dish
     * @param type  type of dish
     * @param price price of dish
     */
    Dish(String name, String type, int price){
        this.name = name;
        this.type = type;
        this.price = price;
    }

    /**
     * Gets the name of the dish
     * @return  Name of dish
     */
    public String getName(){return name;}

    /**
     * Gets the type of the dish
     * @return  type of dish
     */
    public String getType(){return type;}

    /**
     * Get the price of the dish
     * @return  price of dish
     */
    int getPrice(){return price;}

    /**
     * Overrides toString so that we can print a Dish object directly
     * @return  Dish as string
     */
    public String toString(){
        return name + " : " + type + " : " + price;
    }
}
