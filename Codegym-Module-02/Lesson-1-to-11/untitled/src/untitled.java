import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class untitled {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("London");
        set.add("Paris");
        set.add("New York");
        set.add("San Francisco");
        set.add("Beijing");
        set.add("NewYork");
        System.out.println(set);
        System.out.println(set.contains("Beijing"));
    }
}
