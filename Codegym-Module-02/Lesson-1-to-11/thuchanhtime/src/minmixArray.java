import java.util.Arrays;

public class minmixArray {
    public static void main(String[] args) {
        int[] arr1 ={1,2,3,4,5};
        int[] arr2 ={6,7,8,9,0};
        int[] arr3= new int[arr1.length+ arr2.length];

        for(int i = 0; i< arr1.length ; i++){
            arr3[i]=arr1[i];
        }
        for(int i = arr3.length-arr1.length; i<arr3.length;i++){
            arr3[i]=arr2[i- arr2.length];
        }
        System.out.println(Arrays.toString(arr3));
    }
}
