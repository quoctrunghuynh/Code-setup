import java.io.*;
import java.util.Scanner;

public class Machine {
    public void InputStream(String sourcePath, String targetPath) throws IOException {
        InputStream source = null;
        OutputStream target = null;
        int counter = 0;
        try {
            source = new FileInputStream(sourcePath);
            target = new FileOutputStream(targetPath);
            byte[] buffer = new byte[1024];
            int  dataLength;

            while (( dataLength = source.read(buffer)) > 0) {
                target.write(buffer, 0,  dataLength);
                for (int i = 0; i <  dataLength; i++) {
                    if (buffer[i] != '\n' && buffer[i] != '\r' && buffer[i] != '\t' && buffer[i] != ' ') {
                        counter++;
                    }
                }
            }
            System.out.println("Byte: " + counter);
        } finally {
            assert source != null;
            source.close();
            assert target != null;
            target.close();
        }
    }

    public void Processing() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter target: ");
        String target = scanner.nextLine();

        File checkPath = new File(target);
        if (checkPath.exists()) {
            System.out.println("File exist... \nNot execute !");
        } else {
            System.out.println("File not exist...\nStarting to copy...");
            try {
                InputStream(source, target);
                System.out.println("Copy complete !");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
