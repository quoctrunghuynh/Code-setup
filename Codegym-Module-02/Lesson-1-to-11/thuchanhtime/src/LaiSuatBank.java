import java.util.Scanner;

public class LaiSuatBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your investment: ");
        double money = scanner.nextDouble();

        System.out.println("Enter number of months invest: ");
        int month = scanner.nextInt();

        System.out.println("Enter interest rate in percentage: ");
        double interest = scanner.nextDouble();

        double totalInterest = money*(interest/100)/12 * month;

        System.out.println(totalInterest+" is your total of Interest");
    }
}
