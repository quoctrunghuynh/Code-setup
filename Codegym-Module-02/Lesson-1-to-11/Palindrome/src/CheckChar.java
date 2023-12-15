import java.util.*;

public class CheckChar {
    public static void main(String[] args) {
        boolean checki = false;
        Stack<String> charSet = new Stack<>();
        Queue<String> charSet2 = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your input here: ");
        String input = scanner.nextLine();

        String[] Henshin = input.split("", 0);
        System.out.println("Before: " + Arrays.toString(Henshin));

        for (String s : Henshin) {
            charSet.push(s.toLowerCase());
            charSet2.add(s.toLowerCase());
        }
        System.out.println("After: " + charSet);
        System.out.println("After 2: " + charSet2);

        while (!charSet.isEmpty() && !charSet2.isEmpty()) {
            checki = charSet.pop().equals(charSet2.remove());
        }

        if (!checki) {
            System.out.println("Not a palindrome");
        } else System.out.println("It's a palindrome");
    }
}
