

final public class Person {
    private String firstName;
    private String sirName;
    private final int birthYear;

    /**
     * Initializes an object of the person class
     * @param f first name
     * @param s sir name
     * @param b birth year
     */
    Person(String f, String s, int b){
        firstName = f;
        sirName = s;
        birthYear = b;
    }

    /**
     * Gets the person's first name
     * @return first name
     */
    String getFistName(){return firstName;}

    /**
     * Gets the person's last name
     * @return last name
     */
    String getSirName(){return sirName;}

    /**
     * gets the person's birthYear
     * @return birth year
     */
    int getBirthYear(){return birthYear;}

    /**
     * Changes the person's first name
     * @param newName name to change to
     */
    void setFirstName(String newName){
        firstName = newName;
    }

    /**
     * Changes the person's last name
     * @param newSirName name to change to
     */
    void setSirName(String newSirName){
        sirName = newSirName;
    }
}
