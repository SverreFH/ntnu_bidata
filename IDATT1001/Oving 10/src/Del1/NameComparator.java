package Del1;
import java.util.Comparator;

/**
 * A class for comparing the names of two objects of the Arrangement class
 */
public class NameComparator implements Comparator<Arrangement> {
    public int compare(Arrangement a, Arrangement b){
        return a.getName().compareTo(b.getName());
    }
}
