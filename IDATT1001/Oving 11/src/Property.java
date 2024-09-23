

/**
 * A class for holding the necessary components of a Property
 * immutable
 */
public class Property {

    private final int municipalityNumber;
    private final String municipalityName;
    private final int lotNumber;
    private final int sectionNumber;
    private final String name; //ikke alle tomter har navn
    private final double area;
    private final String nameOfOwner;

    /**
     * Creates an object of Property with all the variables initialized to new values
     * @param municipalityNumber    the municipalityNumber of the property
     * @param municipalityName      the name og the municipality that the property is within
     * @param lotNumber             the number of the property's lot
     * @param sectionNumber         the section number of the property
     * @param name                  the name of the property
     * @param area                  the area of the property
     * @param nameOfOwner           the name of the owner of the property
     */
    Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, String name, double area, String nameOfOwner){
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = name;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * Creates an object of Property with all the variables but name initialized to new values
     * @param municipalityNumber    the municipalityNumber of the property
     * @param municipalityName      the name og the municipality that the property is within
     * @param lotNumber             the number of the property's lot
     * @param sectionNumber         the section number of the property
     * @param area                  the area of the property
     * @param nameOfOwner           the name of the owner of the property
     */
    Property(int municipalityNumber, String municipalityName, int lotNumber, int sectionNumber, double area, String nameOfOwner){
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.lotNumber = lotNumber;
        this.sectionNumber = sectionNumber;
        this.name = null;
        this.area = area;
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * Gets the municipality number
     * @return the municipality number
     */
    public int getMunicipalityNumber(){return municipalityNumber;}

    /**
     * Gets the municipality name
     * @return the municipality name
     */
    public String getMunicipalityName(){return municipalityName;}

    /**
     * Gets the lot number
     * @return the lot number
     */
    public int getLotNumber(){return lotNumber;}

    /**
     * Gets the Section Number
     * @return the section number
     */
    public int getSectionNumber(){return sectionNumber;}

    /**
     * Gets the property name
     * @return the property name
     */
    public String getName(){return name;}

    /**
     * Gets the area of the property
     * @return the area of the property
     */
    public double getArea(){return area;}

    /**
     * Gets the name of the owner of the property
     * @return the name of the owner of the property
     */
    public String getNameOfOwner(){return nameOfOwner;}

    /**
     * Returns the property's id, which is a combination of municipalityNumber, lotNumber and sectionNumber
     * @return property id as a string
     */
    public String propertyId(){
        return municipalityNumber + "-" + lotNumber + "/" + sectionNumber;
    }

    /**
     * Overrides the toString method in order to let us print Property objects directly
     * @return  Property as a string
     */
    public String toString(){
        return municipalityNumber + " : " + municipalityName + " : " + lotNumber + " : " + sectionNumber + " : " +
                name + " : " + area + " : " + nameOfOwner;
    }
}
