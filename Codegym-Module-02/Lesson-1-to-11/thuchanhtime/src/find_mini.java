import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class find_mini {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the length of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        int[] completeArr = ranNum(arr);
        int index = minValue(completeArr);
        System.out.println("The smallest element in the array is: "+arr[index]);
    }
    public static int minValue(int[] completeArr){
    int index = 0;
    for (int i = 1; i < completeArr.length; i++){
        if(completeArr[i]<completeArr[index]){
            index = i;
        }
    }
        return index;
    }
    public static int[] ranNum(int[] arr){
        Random random = new Random();
        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
