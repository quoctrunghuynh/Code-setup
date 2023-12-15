import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class DeletElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter the length of the list: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for(int i=0; i<size;i++){
            arr[i] =random.nextInt(100);
        }

        System.out.println(Arrays.toString(arr));

        System.out.println("Enter the element's name you want to delete: ");
        int name = scanner.nextInt();
        int located=-1;
        for(int i=0; i<size ;i++){
            if(arr[i] == name){
                located = i;
                break;
            }
        }
        if(located != -1) {
                for (int k = located; k < size-1; k++) {
                    arr[k] = arr[k + 1];
                }
                arr[size-1]=0;
            }
                System.out.println(Arrays.toString(arr));
    }
}

