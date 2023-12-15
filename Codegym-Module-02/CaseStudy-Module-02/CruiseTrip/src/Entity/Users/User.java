package Entity.Users;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class User {
    private final int id;
    private final String email;
    private final String telephone;
    private final String password;
    private final String firstName;
    private final String lastName;
}
