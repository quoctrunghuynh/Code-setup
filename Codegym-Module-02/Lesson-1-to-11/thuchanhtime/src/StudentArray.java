import java.util.Arrays;
import java.util.Scanner;

public class StudentArray {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);
        int Size = 1;

        do {
            try {
                System.out.print("Enter the length of the list: ");
                Size = Integer.parseInt(scanner.nextLine());
                break;
            }
            catch (NumberFormatException Error){
                System.out.println("Something wrong , please try again");
            }

        } while (true);

        String[] array = new String[Size];

        for (int i = 0; i < Size; i++) {
            System.out.print("Enter number " + (i + 1) + "'s name: ");
            String s = scanner.nextLine();
            array[i] = s;
        }
        System.out.println(Arrays.toString(array));

        System.out.print("Enter the name you want to find: ");
        String input_name = scanner.nextLine();

        boolean isExist = false;
        for (int i = 0; i < array.length ; i++){
            if(array[i].equals(input_name)){
                System.out.println("The student named "+ input_name + " located at "+ (i+1)+" in the list");
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Not found "+input_name+" in the list");
        }
    }
}
