import java.util.ArrayList;

public class ItemRegister {

    private ArrayList<Item> itemRegister;

    /**
     * Overrides toString in order to let us print itemRegister objects directly
     * @return itemRegister as a string
     */
    public String toString(){
        return itemRegister.toString();
    }

    /**
     * Lets us search the list of items by item number
     * @param itemNumber    item number of item we are searching for
     * @return              Item with the given item number
     */
    public Item searchForItemWithNumber(String itemNumber){
        for (Item item : itemRegister) {
            if (item.getItemNumber().equals(itemNumber)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Lets us search the list of items by description
     * @param description   description of the item we are searching for
     * @return              Item with the given description
     */
    public Item searchForItemWithDescription(String description){
        for (Item item : itemRegister){
            if(item.getDescription().equals(description)){
                return item;
            }
        }
        return null;
    }

    //Burde denne lage item objectet, eller er det best å gjøre i main?

    /**
     * Lets us add an item to itemRegister
     * @param item  item to be added to register
     */
    public void addItem(Item item){
        itemRegister.add(item);
    }

    /**
     * Lets us delete and item from itemRegister
     * @param itemNumber    item number of item to be removed
     */
    public void deleteItem(String itemNumber){
        Item itemToDelete = searchForItemWithNumber(itemNumber);
        itemRegister.remove(itemToDelete);
    }

    /**
     * Lets us increase the stock of a given item in the register
     * @param itemNumber    item number of the item to increase stock of
     * @param increaseBy    amount to increase stock by
     */
    public void increaseStock(String itemNumber, int increaseBy){
        Item itemToIncrease = searchForItemWithNumber(itemNumber);
        itemToIncrease.setNumberInStock(itemToIncrease.getNumberInStock()+increaseBy);
    }

    /**
     * Lets us decrease the stock of a given item in the register
     * @param itemNumber    item number of the item to decrease stock by
     * @param decreaseBy    amount to decrease stock by
     */
    public void decreaseStock(String itemNumber, int decreaseBy){
        Item itemToDecrease = searchForItemWithNumber(itemNumber);
        itemToDecrease.setNumberInStock(itemToDecrease.getNumberInStock()-decreaseBy);
    }

    /**
     * Lets us change the price of a given item in the register
     * @param newPrice              Price to change too
     * @param itemNumberToChange    item number of the item to change the price of
     */
    public void changePrice(int newPrice, String itemNumberToChange){
        for (Item item : itemRegister) {
            if (item.getItemNumber().equalsIgnoreCase(itemNumberToChange)) {
                item.setPrice(newPrice);
            }
        }
    }

    /**
     * Lets us change the description of a given item in the register
     * @param newDescription        Description to change too
     * @param itemNumberToChange       item number of the item to change the description of
     */
    public void changeDescription(String newDescription, String itemNumberToChange){
        for(Item item : itemRegister){
            if(item.getItemNumber().equalsIgnoreCase(itemNumberToChange)){
                item.setDescription(newDescription);
            }
        }
    }

}
