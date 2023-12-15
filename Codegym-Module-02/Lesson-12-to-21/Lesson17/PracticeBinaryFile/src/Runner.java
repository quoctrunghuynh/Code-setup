import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void writeDataToFile(String path, List<Student> students){
        try{
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(students);
            oos.close();
            fos.close();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
    public static List<Student> readDataFromFile(String path){
        List<Student> students = new ArrayList<>();
        try{
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return students;
    }
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Pepi","Vị Thanh"));
        students.add(new Student(2,"Papi","Hồ Chí Minh"));
        students.add(new Student(3,"Tiny","Unknown"));
        writeDataToFile("students.txt",students);
        List<Student> studentDataFromFile = readDataFromFile("students.txt");
        for(Student student : studentDataFromFile){
            System.out.println(student);
        }
    }
}
