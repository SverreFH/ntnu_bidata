package Del1;

import java.util.Comparator;

/**
 * A class for comparing the type of two Arrangement objects
 */
public class TypeComparator implements Comparator<Arrangement> {
    public int compare(Arrangement a, Arrangement b){
        return a.getType().compareTo(b.getType());
    }
}
