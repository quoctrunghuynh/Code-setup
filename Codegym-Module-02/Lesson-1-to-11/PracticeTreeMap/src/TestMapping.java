import java.util.Scanner;
import java.util.TreeMap;

public class TestMapping {
    public static final int ONE = Number.one;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your input: ");
        String input = scanner.nextLine();

        String[] scrap = input.split("");

        TreeMap<String, Integer> mappi = new TreeMap<>();
        for (String s : scrap) {
            if (!mappi.containsKey(s)) {
                mappi.put(s, ONE);
            } else {
                mappi.put(s, mappi.get(s) + ONE);
            }
        }
        System.out.println(mappi);
    }
}
