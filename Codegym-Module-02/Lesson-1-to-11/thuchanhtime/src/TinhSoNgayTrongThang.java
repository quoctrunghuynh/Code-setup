import java.util.Scanner;

public class TinhSoNgayTrongThang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the month: ");
        int Mm = scanner.nextInt();

        switch (Mm) {
            case 2 -> System.out.println(" The month " + Mm + " has 28 or 29 days");

            case 1, 3, 5, 7, 8, 10, 12 -> System.out.println(" The month " + Mm + " has 31 days");

            case 4, 6, 9, 11 -> System.out.println(" The month " + Mm + " has 30 days");
        }
    }
}
