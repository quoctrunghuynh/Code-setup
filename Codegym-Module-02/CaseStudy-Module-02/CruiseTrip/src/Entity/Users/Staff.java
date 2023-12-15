package Entity.Users;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Staff extends User {
    @Override
    public String toString() {
        return "Staff:" + super.getFirstName() +
                ":" + super.getLastName() +
                ":" + super.getEmail() +
                ":" + super.getTelephone() +
                ":" + super.getPassword() +
                "\n";
    }
}
