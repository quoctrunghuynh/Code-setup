import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.sqrt;

public class QuadraticEquation {
    static Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    public static void main(String[] args) {
        System.out.println("This is a QuadraticEquation ");
        System.out.println("-->> ax^2 + bx +c = 0 <<--");

        System.out.println("Enter your a number: ");
        double a = scanner.nextDouble();

        System.out.println("Enter your b number: ");
        double b = scanner.nextDouble();

        System.out.println("Enter your c number: ");
        double c = scanner.nextDouble();

        double delta = getDiscriminant(a,b,c);
        System.out.println("This is your delta: "+delta);

        if(delta>0){
            System.out.println("This equation higher than 0 so it has 2 roots ");
            double root1 = getRoot1(a,b,delta);
            double root2 = getRoot2(a,b,delta);
            System.out.println("This is your result: ");
            System.out.println("Root 1= "+root1);
            System.out.println("Root 2= "+root2);
        }
        if(delta==0){
            System.out.println("This equation equal 0 so it has 1 root");
            double root1 = getRoot1(a,b,delta);
            System.out.println("Same root: "+root1);
        }
        if(delta<0){
            System.out.println("This equation has no real root");
        }

    }
    public static double getDiscriminant(double a, double b, double c)
    {
    double delta = Math.pow(b,2) - 4*a*c;
        System.out.println("This is your delta: ");
        System.out.println(delta);
        return delta;
    }

    public static double getRoot1(double a, double b, double delta){
        return (-b+sqrt(delta))/2*a;
    }
    public static double getRoot2(double a, double b, double delta){
        return (b+sqrt(delta))/2*a;
    }
}
