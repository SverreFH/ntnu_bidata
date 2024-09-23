package Del1;

import java.util.Comparator;

/**
 * A class for comparing the location of two objects of the Arrangement class
 */
public class PlaceComparator implements Comparator<Arrangement> {
    public int compare(Arrangement a, Arrangement b){
        return a.getLocation().compareTo(b.getLocation());
    }
}
