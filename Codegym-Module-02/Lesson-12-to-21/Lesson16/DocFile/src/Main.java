import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        File file = new File("target.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            ArrayList<String> result = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                result.add(line.split(",")[2]);
            }
            bufferedReader.close();
            for (String s : result) {
                System.out.println(s);
            }

        } catch (Exception e) {
            System.out.println("Something wrong...");
        }
    }
}
