import java.util.Scanner;
import java.util.Stack;

public class FromD2B {
    static Stack<Number> result = new Stack<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int input = scanner.nextInt();
        int temp = 0;
        StringBuilder Final = new StringBuilder();
        while (input >= 1) {

            temp = input % 2;
            input = input / 2;

            result.push(temp);
        }
        while (!result.isEmpty()) {
            Final.append(result.pop());
        }
        System.out.println(Final);
    }
}
