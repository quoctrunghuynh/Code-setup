import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlSong {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.baby-chick.com/beautiful-girl-names/");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content = content.replaceAll("\\n+", "");
            Pattern p = Pattern.compile("short-p\">(.*?)</p>");
            Matcher matcher = p.matcher(content);
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
