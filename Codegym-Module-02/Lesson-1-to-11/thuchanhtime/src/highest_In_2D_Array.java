import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class highest_In_2D_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Enter X: ");
        int sizeX = scanner.nextInt();
        System.out.println("Enter Y: ");
        int sizeY = scanner.nextInt();

        int[][] arrMain = createArr(sizeX, sizeY, random);
        System.out.println("This is your array");
        // cach 2 de in mang
        //        System.out.println(Arrays.deepToString(arrMain));
        for (int[] row : arrMain) {
            System.out.println(Arrays.toString(row));
        }
        int[] maxInt = findMax(arrMain, sizeX, sizeY);
        System.out.println("The highest element in your array is: ");
        System.out.println(maxInt[0]);
        System.out.println("And it's position is:  "+maxInt[1]+" "+maxInt[2]);
    }

    public static int[][] createArr(int sizeX, int sizeY, Random random) {
        int[][] arr = new int[sizeX][sizeY];

        for (int i = 0; i < sizeX; i++) {

            for (int j = 0; j < sizeY; j++) {

                arr[i][j] = random.nextInt(100);
            }
        }
        return arr;
    }

    public static int[] findMax(int[][] arr, int sizeX, int sizeY) {
        int max = 0;
        int posx = 0;
        int posy = 0;
        for (int i = 0; i < sizeX; i++) {

            for (int j = 0; j < sizeY; j++) {

                if (max < arr[i][j])
                {
                    max = arr[i][j];

                    posx = i;
                    posy = j;
                }
            }
        }
        return new int[]{max,posx,posy};

    }
}
