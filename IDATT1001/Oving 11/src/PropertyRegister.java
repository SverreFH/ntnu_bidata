
import java.util.ArrayList;

/**
 * A class for holding and modifying a list of Property objects
 * Mutable
 */
public class PropertyRegister {

    private final ArrayList<Property> register;

    //Benytter aggregering? Burde man bruke composisjon?
    PropertyRegister(ArrayList<Property> register){
        this.register = register;
    }

    /**
     * Adds a property to the register arrayList
     * @param propertyToAdd Property being added to the list
     */
    public void addProperty(Property propertyToAdd){
        register.add(propertyToAdd);
    }

    /**
     * Removes a property from the register arrayList
     * @param propertyToRemove property to be removed
     */
    public void removeProperty(Property propertyToRemove){
        register.remove(propertyToRemove);
    }

    /**
     * Get the number of property objects in the register
     * @return  number of properties
     */
    public int getNumberOfPropertiesInRegister(){
        return register.size();
    }

    /**
     * Print the register of properties
     */
    public void printProperties(){
        System.out.println(register);
    }

    /**
     * Lets you find a property by its id, which is a combination of municipality-, lot- and section number
     * @param municipalityNumber    Number of municipality that the property is within
     * @param lotNumber             Lot number of the property
     * @param sectionNumber         Section number of the property
     * @return                      Property that matches the id or null if property with id doesn't exist
     */
    public Property findProperty(int municipalityNumber, int lotNumber, int sectionNumber){
        for (Property property : register) {
            if (property.getMunicipalityNumber() == municipalityNumber && property.getLotNumber() == lotNumber
                    && property.getSectionNumber() == sectionNumber) {
                return property;
            }
        }
        return null;
    }

    /**
     * Gets the average area of all the properties in the register
     * @return  average area of properties in register
     */
    public double averageAreOfProperties(){
        double total = 0;
        for (Property property : register) {
            total += property.getArea();
        }
        return total/register.size();
    }

    /**
     * overrides toString in order to let us print PropertyRegister objects directly
     * @return  PropertyRegister as a string
     */
    public String toString(){
        return register.toString();
    }

    /**
     * Lets you find all properties with a given lot number
     * @param lotNumber number to search for
     * @return          List of properties with lot number
     */
    public ArrayList<Property> findPropertiesWithLotNumber(int lotNumber){
        ArrayList<Property> propertiesWithLotNumber = new ArrayList<>();
        for (Property property : register) {
            if (property.getLotNumber() == lotNumber) {
                propertiesWithLotNumber.add(property);
            }
        }
        return propertiesWithLotNumber;
    }
}

