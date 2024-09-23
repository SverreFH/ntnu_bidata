package Del1;

import java.util.Comparator;

/**
 * A class for comparing the time of two objects of the Arrangement class
 */
public class TimeComparator implements Comparator<Arrangement>{
    public int compare(Arrangement a, Arrangement b){
        return Long.compare(a.getTime(), b.getTime());
    }
}
