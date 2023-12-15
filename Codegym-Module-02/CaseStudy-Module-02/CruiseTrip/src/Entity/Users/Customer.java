package Entity.Users;

import Services.CustomerServices;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class Customer extends User {
    private String Ticket;

    @Override
    public String toString() {
        return "Customer:" + super.getId() +
                ":" + super.getFirstName() +
                ":" + super.getLastName() +
                ":" + super.getEmail() +
                ":" + super.getTelephone() +
                ":" + super.getPassword() + "\n";
    }

    public void logout() {
        CustomerServices.currentCustomer = null;
    }
}
