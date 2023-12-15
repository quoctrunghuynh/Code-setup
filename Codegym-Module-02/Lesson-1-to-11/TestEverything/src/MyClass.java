import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyClass {
    ArrayList<String> collection = new ArrayList<>();
    collection.add("New York"); collection.add("Atlanta"); 
    collection.add("Dallas"); collection.add("Madison");
    Iterator<String> iterator = collection.iterator();
    while(iterator.hasNext())

    {
        System.out.print(iterator.next().toUpperCase() + " ");
    }
}

