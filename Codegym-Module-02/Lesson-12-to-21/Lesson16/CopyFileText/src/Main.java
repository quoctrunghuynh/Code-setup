import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CopyPaste copyPaste = new CopyPaste();
        List<String> copyTo;
        copyTo = copyPaste.ReadScraps("Source.txt");
        copyPaste.WriteScraps("target.txt",copyTo);
    }
}
