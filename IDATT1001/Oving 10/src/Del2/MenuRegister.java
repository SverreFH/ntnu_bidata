package Del2;

import java.util.ArrayList;

/**
 * A class for holding and manipulating a list of menu objects
 */
public class MenuRegister {
    private final ArrayList<Menu> menuArrayList;

    /**
     * Initializes an object of MenuRegister
     * @param menuList  list of menus
     */
    MenuRegister(ArrayList<Menu> menuList){menuArrayList = menuList;}

    /**
     * Adds a dish to a menu in the list of menus
     * @param dish      Dish to add
     * @param menuName  Name of menu to add dish to
     */
    public void addDish(Dish dish, String menuName){
        for(int i = 0; i < menuArrayList.size(); i++){
            if(menuArrayList.get(i).getRestaurantName().equalsIgnoreCase(menuName)){
                menuArrayList.get(i).addDish(dish);
            }
        }
    }

    /**
     * Find all instances of a dish across the menus in the list of menus
     * @param dishName  Name of dish to find
     * @return          List of instances of the dish found
     */
    public ArrayList<Dish> findDishByName(String dishName){
        ArrayList<Dish> listOfDishesWithName = new ArrayList<>();
        for(int i = 0; i < menuArrayList.size(); i++){
            for(int j = 0; j < menuArrayList.get(i).getMenu().size(); j++){
                if(menuArrayList.get(i).getMenu().get(j).getName().equalsIgnoreCase(dishName)){
                    listOfDishesWithName.add(menuArrayList.get(i).getMenu().get(j));
                }
            }
        }
        return listOfDishesWithName;
    }

    /**
     * Finds all dishes of a type
     * @param type  type to find
     * @return      list of all dishes of type
     */
    public ArrayList<Dish> findAllDishesOfType(String type){
        ArrayList<Dish> listOfDishesOfType = new ArrayList<>();
        for (int i = 0; i < menuArrayList.size(); i++){
            for(int j = 0; j < menuArrayList.get(i).getMenu().size(); j++){
                if(menuArrayList.get(i).getMenu().get(j).getType().equalsIgnoreCase(type)){
                    listOfDishesOfType.add(menuArrayList.get(i).getMenu().get(j));
                }
            }
        }
        return listOfDishesOfType;
    }

    /**
     * Adds a menu to the list of menus
     * @param menu menu to add
     */
    public void addMenu(Menu menu){
        menuArrayList.add(menu);
    }

    /**
     * Finds all menus within price range
     * @param price maks price
     * @return      list off all menus within price range
     */
    public ArrayList<Menu> menusWithinPriceRange(int price){
        ArrayList<Menu> listOfMenusInPriceRange = new ArrayList<>();
        for(int i = 0; i < menuArrayList.size(); i++){
            if (menuArrayList.get(i).findTotalPrice() <= price){
                listOfMenusInPriceRange.add(menuArrayList.get(i));
            }
        }
        return listOfMenusInPriceRange;
    };

    /**
     * Overrides toString to lets us print MenuRegister objects directly
     * @return  MenuRegister as string
     */
    public String toString(){
        return menuArrayList.toString();
    }
}