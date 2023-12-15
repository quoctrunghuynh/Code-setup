import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class maxinArrays {

    public static void main(String[] args) {
        Random random = new Random();

        Scanner scanner = new Scanner(System.in);

        int[] array;

        System.out.println("Enter the length of the random numbers: ");
        int size = scanner.nextInt();

        array = new int[(int) size];
        int max =0;
        for(int i = 0; i < size; i++){
            array[i] = random.nextInt(100);
            if(array[i]>max){
                max = array[i];
            }
        }
        System.out.println(Arrays.toString(array));
        System.out.println("The highest number is: "+max);
    }
}
