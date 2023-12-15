package Services;

import Entity.Users.Customer;

public interface UserServices {
    void signIn();

    void register();

    boolean check(int number, String input);

    void userSelect();

    void createUser(String firstName, String lastName, String number, String email, String password);

    int getNewId();

    Customer getCurrentCustomer(String[] currentCustomer);


    void customerSelect();
}
