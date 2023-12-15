import java.util.Comparator;

public class CompareDob implements Comparator<Info> {
    public int compare(Info a, Info b) {
        return a.getDob().compareTo(b.getDob());
    }
}


