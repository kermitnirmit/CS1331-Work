import java.util.Comparator;

public class DobieComparator implements Comparator<Doberman> {
    public int compare(Doberman a, Doberman b) {
        return a.getName().compareTo(b.getName());
    }
}
