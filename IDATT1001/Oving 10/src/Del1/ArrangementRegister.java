package Del1;

import java.util.ArrayList;

/**
 * A class for holding a list of arrangements
 */
public class ArrangementRegister{
    private final ArrayList<Arrangement> arrangements = new ArrayList<Arrangement>();

    /**
     * Adds an arrangement to the list of arrangements.
     * @param a arrangement to add
     */
    public void addArrangement(Arrangement a){
        arrangements.add(a);
    }

    /**
     * Creates a list of all arrangements that happen at a specified location
     * @param location location to check if arrangements are happening at
     * @return          list of arrangements that happen ata specified location
     */
    public ArrayList<Arrangement> findArrangementsAtLocation(String location){
        PlaceComparator placeComparator = new PlaceComparator();
        ArrayList<Arrangement> ArrangementsAtLocation = new ArrayList<Arrangement>();
        for (Arrangement arrangement : arrangements){
            if(arrangement.getLocation().equalsIgnoreCase(location)){
                ArrangementsAtLocation.add(arrangement);
            }
        }
        ArrangementsAtLocation.sort(placeComparator);
        return ArrangementsAtLocation;
    }

    /**
     * Creates a list of all arrangements that happen at a specified time
     * @param date  Time to check if arrangements are happening at
     * @return      List of arrangements happening at specified time
     */
    public ArrayList<Arrangement> findArrangementsAtDate(long date){
        TimeComparator timeComparator = new TimeComparator();
        ArrayList<Arrangement> ArrangementsAtDate =  new ArrayList<Arrangement>();
        for(Arrangement arrangement : arrangements){
            if(arrangement.getTime() == date){
                ArrangementsAtDate.add(arrangement);
            }
        }
        ArrangementsAtDate.sort(timeComparator);
        return ArrangementsAtDate;
    }

    /**
     * Creates a sorted time sorted list of all arrangements happening between to specified times
     * @param lower Lower limit for time that arrangements can be happening at
     * @param upper Upper limit for time that arrangements can be happening at
     * @return      Time sorted list of arrangements happening between specified times
     */
    public ArrayList<Arrangement> ArrangementsWithinTimeRange(long lower, long upper){
        ArrayList<Arrangement> timeArrangements = new ArrayList<Arrangement>();
        TimeComparator timeComparator = new TimeComparator();
        for (Arrangement arrangement : arrangements) {
            if (arrangement.getTime() >= lower && arrangement.getTime() <= upper) {
                timeArrangements.add(arrangement);
            }
        }
        timeArrangements.sort(timeComparator);
        return timeArrangements;
    }

    /**
     * Sorts the list of arrangements by name
     */
    public void listSortedByName(){
        NameComparator nameComparator = new NameComparator();
        arrangements.sort(nameComparator);
    }

    /**
     * Sorts the list of arrangements by place
     */
    public void listSortedByPlace(){
        PlaceComparator placeComparator = new PlaceComparator();
        arrangements.sort(placeComparator);
    }

    /**
     * Sorts the list of arrangements by type
     */
    public void listSortedByType(){
        TypeComparator typeComparator = new TypeComparator();
        arrangements.sort(typeComparator);
    }

    /**
     * Sorts the list of arrangements by time
     */
    public void listSortedByTime(){
        TimeComparator timeComparator = new TimeComparator();
        arrangements.sort(timeComparator);
    }

    /**
     * Overrides the toString method to let us directly print ArrangementRegister objects
     * @return  ArrangementRegister as a string
     */
    public String toString(){

        return arrangements.toString();
    }


}
