import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWrite {
    public List<Integer> ReadFile(String filePath) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader bReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            bReader.close();
        } catch (Exception e) {
            System.out.println("File does not exist or the content contained false input");
        }
        return numbers;
    }

    public void WriteFile(String filePath, int max) {
        try {
            File file = new File(filePath);
            BufferedWriter bWrite = new BufferedWriter(new FileWriter(file));
            bWrite.write("Giá trị lớn nhất là " + max);
            bWrite.close();

        } catch (Exception e) {
            System.out.println("File does not exist or the content contained false input");
        }
    }
}
