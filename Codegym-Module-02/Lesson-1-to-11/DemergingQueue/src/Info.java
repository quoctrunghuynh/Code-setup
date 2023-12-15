import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Info {

    private String name;
    private boolean sex;
    private Date dob;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public Info() {

    }

    public Info(String name, boolean sex, Date dob) {
        this.name = name;
        this.sex = sex;
        this.dob = dob;
    }

    public Info(String[] input) throws ParseException {
        Date date = new Date();

        this.name = input[0];
        this.sex = Boolean.parseBoolean(input[1]);
        this.dob = formatter.parse(input[2]);
    }

    public boolean isSex() {
        return sex;
    }

    public Date getDob() {
        return dob;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public void getScrap() throws FileNotFoundException {
        FileReader fileReader = new FileReader("list.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        List<Info> infoArrayList = new ArrayList<>();
        String line;
        String[] input;

        try {
            while ((line = reader.readLine()) != null) {
                input = line.split("/");
                Info info = new Info(input);
                infoArrayList.add(info);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        infoArrayList.sort(new CompareDob());
        System.out.println(infoArrayList);
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", dob='" + dob + '\'' +
                '}';
    }
}


