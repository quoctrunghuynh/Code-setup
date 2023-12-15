import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class User {
     private final String firstName;
     private final String lastName;
     private final String email;
     private final String password;
     private final String telephone;

     @Override
     public String toString() {
          return "User{" +
                  "firstName='" + firstName + '\'' +
                  ", lastName='" + lastName + '\'' +
                  ", email='" + email + '\'' +
                  ", password='" + password + '\'' +
                  ", telephone='" + telephone + '\'' +
                  '}';
     }
}
