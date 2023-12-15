import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Customer extends User {
    private String cardNumber;
    @Override
    public String toString() {
        return "Staff:" + super.getFirstName() +":"+
                super.getLastName() +":"+
                super.getEmail()+":"+
                super.getTelephone()+":"+
                super.getPassword()+":"+
                cardNumber;
    }
}