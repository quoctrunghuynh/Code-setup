import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Trung", 24, "BTan");
        Student student1 = new Student("Chung", 28, "BChanh");
        Student student2 = new Student("Huy", 29, "BChanh" );
        Student student3 = new Student("Phat", 24, "7" );

        List<Student> lists = new ArrayList<Student>();
        lists.add(student);
        lists.add(student1);
        lists.add(student2);
        lists.add(student3);
        Collections.sort(lists);
        for(Student st : lists){
            System.out.println(st.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(lists, ageComparator);
        System.out.println("So sánh theo tuổi:");
        for(Student st : lists){
            System.out.println(st.toString());
        }
    }
}
