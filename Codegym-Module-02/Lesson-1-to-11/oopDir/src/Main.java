import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the width: ");
        double width = scanner.nextDouble();

        System.out.println("Enter the height: ");
        double height =  scanner.nextDouble();

        recti rectangle = new recti(width, height);

        System.out.println("Your rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the rectangle: "+rectangle.getArea());
    }
}
