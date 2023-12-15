import java.util.Scanner;

public class drawmenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangles");
        System.out.println("3. Print the isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Tell me your selection: ");
        int select = scanner.nextInt();

        switch (select){
            case 1:
                System.out.print("How big is the rectangle? ");
                int size1 = scanner.nextInt();
                System.out.println("This is your rectangle: ");
                for (int i=0; i < size1 ; i++){
                    for (int j=0 ; j < size1-1 ; j++){
                        System.out.print("* ");
                    }
                    System.out.println("* ");
                }
                break;
            case 2:
                System.out.print("How big is the square triangles? ");
                int size2 = scanner.nextInt();
                System.out.println("This is your bottom left square triangles: ");
                for (int i = 0; i <= size2 ; i++){
                    for (int j = 0; j < i ; j++){
                        System.out.print("* ");
                    }
                    System.out.println("* ");
                }
                System.out.println("This is your bottom right square triangles: ");
                for (int i = 0; i <= size2 ; i++){
                    for (int j = 0; j < i ; j++){
                        System.out.print("* ");
                    }
                    System.out.println("* ");
                }
            case 3:
                int a = (int)Math.round(12 * Math.random()) + 5;
                System.out.println(a);
        }
    }
}
