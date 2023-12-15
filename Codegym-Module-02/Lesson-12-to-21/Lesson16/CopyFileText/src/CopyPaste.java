import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CopyPaste {
    public List<String> ReadScraps(String source) {
        File file = new File(source);
        List<String> copiedContent = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String line;

            if (!file.exists()) {
                throw new IOException();
            }
            while ((line = bufferedReader.readLine()) != null) {
                copiedContent.add(line);
            }

            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("File not found or file's content is unavailable to read");
        }
        return copiedContent;
    }

    public void WriteScraps(String target, List<String> copiedContent) {
        File file = new File(target);
        if (Objects.equals(target, "")) {
            System.out.println("File hasn't been created, creating new file...");
        } else {
            System.out.println("Overdrive the file...");
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (String line : copiedContent) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("Something wrong with the content please contact with the handsome Author");
        }
    }
}
