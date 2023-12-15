import java.util.Scanner;

public class LinearEquationResolve {
    public static void main(String[] args) {
        System.out.println("This is Linear Equation Resolver");
        System.out.println("Given a equation ax+b=c, please enter your input");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input a: ");
        double a = scanner.nextDouble();

        System.out.println("Input b: ");
        double b = scanner.nextDouble();

        System.out.println("Input c: ");
        double c = scanner.nextDouble();

        if(a != 0){
            double result = (c - b)/a;
            System.out.println("The result is: "+ result);
        }
        else{
            if(b == c){
                System.out.println("The result is all x!");
            }
            else{
                System.out.println("No solution babe...Try again sometimes");
            }
        }
    }
}
