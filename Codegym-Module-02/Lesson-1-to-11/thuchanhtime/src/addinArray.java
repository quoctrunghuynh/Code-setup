import java.util.Arrays;
import java.util.Scanner;

public class addinArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arr[]={1,2,3,4,5,6,7,8,9,0,0,0};

        int temp=0;
        int temp2=0;
        System.out.println("Enter the element you want to add: ");
        int addx= scanner.nextInt();
        System.out.println("Enter the position you want to add: ");
        int posx= scanner.nextInt();

        if(posx <0 || posx >= arr.length-1){
            System.out.println("No babe, try again");
        }
        else{
            temp= arr[posx];
            arr[posx]=addx;
            for(int i = posx+1; i<arr.length-1; i++){
                temp2=arr[i];
                arr[i]=temp;
                temp = temp2;

            }
            System.out.println(Arrays.toString(arr));
        }

    }



}
