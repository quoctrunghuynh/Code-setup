import com.codegym.dao.UserDAO;
import com.codegym.model.User;

public class Main {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();
//        User user = User.builder()
//                .id(1)
//                .name("Trung")
//                .email("hqtrung")
//                .country("VN")
//                .build();
        User user = new User();
        user.setName("ádfád");
        System.out.println(user.getName());
    }
}
