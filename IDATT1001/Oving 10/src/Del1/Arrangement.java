package Del1;

/**
 * A class for holding all the necessary information that a arrangement needs
 */
public class Arrangement implements Comparable<Arrangement>{
    private final int arrangementNumber;
    private final String name;
    private final String location;
    private final String organizer;
    private final String type;
    private final long time;

    /**
     * Initializes an Arrangement object
     * @param an    arrangement number
     * @param n     arrangement name
     * @param l     arrangement location
     * @param o     arrangement organizer
     * @param t     arrangement type
     * @param ti    arrangement time
     */
    Arrangement(int an, String n, String l, String o, String t, long ti){
        arrangementNumber = an;
        name = n;
        location = l;
        organizer = o;
        type = t;
        time = ti;
    }

    /**
     * Gets the time of the arrangement
     * @return  time that the arrangement happens at
     */
    public long getTime(){return time;}

    /**
     * Gets the location of the arrangement
     * @return  location of arrangement
     */
    public String getLocation(){return location;}

    /**
     * Gets the name of the arrangement
     * @return name of arrangement
     */
    public String getName(){return name;}

    /**
     * Gets the type of the arrangement
     * @return type of arrangement
     */
    public String getType(){return type;}

    /**
     * Default compareTo that compares the name of arrangements.
     *
     * @param a the object to be compared.
     * @return returns an int value. Negative value if this arrangement happens before the compared arrangement
     * And opposite if this arrangement happens after the compared arrangement.
     */
    public int compareTo(Arrangement a){
        return this.name.compareTo(a.getName());
    }

    /**
     * overrides the toString method in order to let us print Arrangement objects directly.
     * @return  Arrangement as a string.
     */
    public String toString(){
        return arrangementNumber + " : " + name + " : " + location + " : " + organizer + " : " + type + " : " + time;
    }

}
