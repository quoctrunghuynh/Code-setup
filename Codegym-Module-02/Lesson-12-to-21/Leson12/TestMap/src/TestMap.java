import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Human",10);
        hashMap.put("Children",22);
        hashMap.put("Woman",13);
        System.out.println("Display entries in hashMap: ");
        System.out.println(hashMap+"\n");

        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println(treeMap);


    }
}
