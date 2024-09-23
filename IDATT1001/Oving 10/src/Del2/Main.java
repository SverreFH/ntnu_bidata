package Del2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dish DishTest = new Dish("Salad","Appetizer",70);
        Dish DishTest2 = new Dish("Herb crusted lamb", "Main",260);
        Dish DishTest3 = new Dish("cream brule", "Dessert",110);

        ArrayList<Dish> dishList = new ArrayList<>();
        dishList.add(DishTest);
        dishList.add(DishTest2);
        dishList.add(DishTest3);
        ArrayList<Dish> dishList2 = new ArrayList<>();
        dishList2.add(DishTest);
        dishList2.add(DishTest2);
        dishList2.add(DishTest3);
        Menu menuTest = new Menu(dishList, "Olav's bistro");
        Menu menuTest2 = new Menu(dishList2, "Larsen's grill");
        ArrayList<Menu> menuArrayList = new ArrayList<>();
        menuArrayList.add(menuTest);
        menuArrayList.add(menuTest2);
        MenuRegister finalTest = new MenuRegister(menuArrayList);

        Scanner inp = new Scanner(System.in);
        int i = 0;
        while(i==0) {
            System.out.println("1: Find dish by name");
            System.out.println("2: Find dish by type");
            System.out.println("3: Add new menu to register");
            System.out.println("4: Add dish to a menu");
            System.out.println("5: Find menus within price range");
            System.out.println("6: print menu register");
            System.out.println("0: cancel");
            int task = inp.nextInt();
            switch (task) {
                case 1:
                    System.out.println("Dish to search for?");
                    String dish = inp.next();
                    System.out.println(finalTest.findDishByName(dish));
                    break;
                case 2:
                    System.out.println("Type of dish to search for?");
                    String typeDish = inp.next();
                    System.out.println(finalTest.findAllDishesOfType(typeDish));
                    break;
                case 3:
                    int index = 0;
                    ArrayList<Dish> dishList3 = new ArrayList<>();
                    System.out.println("Name of menu being added?");
                    String newMenuName = inp.next();
                    Menu menuList = new Menu(dishList3, newMenuName);
                    finalTest.addMenu(menuList);
                    while(index == 0){
                        System.out.println("Add dish to new menu? y/n");
                        String addNew = inp.next();
                        if(addNew.equals("y")){
                            System.out.println("Name of dish being added?");
                            String nameOfDish = inp.next();
                            System.out.println("Type of dish being added?");
                            String typeOfDish = inp.next();
                            System.out.println("Price of dish being added?");
                            int priceOfDish = inp.nextInt();
                            inp.nextLine();
                            Dish addDish = new Dish(nameOfDish, typeOfDish, priceOfDish);
                            finalTest.addDish(addDish,newMenuName);
                        }
                        else{
                            index++;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Name of dish being added?");
                    String nameOfDish = inp.next();
                    System.out.println("Type of dish being added?");
                    String typeOfDish = inp.next();
                    System.out.println("Price of dish being added?");
                    int priceOfDish = inp.nextInt();
                    inp.nextLine();
                    System.out.println("Menu name?");
                    String menuName = inp.nextLine();
                    Dish addDish = new Dish(nameOfDish, typeOfDish, priceOfDish);
                    finalTest.addDish(addDish,menuName);
                    break;
                case 5:
                    System.out.println("Max prize?");
                    int maxPrice = inp.nextInt();
                    System.out.println(finalTest.menusWithinPriceRange(maxPrice));
                    break;
                case 6:
                    System.out.println(finalTest);
                    break;
                case 0:
                    i++;
                    break;
            }
        }
    }
}