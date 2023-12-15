import lombok.experimental.SuperBuilder;
@SuperBuilder
public class Staff extends User{
    private final int level;
    private final double salary;
    @Override
    public String toString() {
        return "Customer:" + super.getFirstName() +":"+
                super.getLastName() +":"+
                super.getEmail()+":"+
                super.getTelephone()+":"+
                super.getPassword()+":"+
                level+":"+
                salary;
    }
}
