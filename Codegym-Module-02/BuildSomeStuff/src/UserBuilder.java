public class UserBuilder {
    private int id;
    private String name;
    private String email;
    private String password;

    public UserBuilder id(int id) {
        this.id = id;
    }

    public UserBuilder name(String name) {
        this.name = name;
    }

    public UserBuilder email(String email) {
        this.email = email;
    }

    public UserBuilder password(String password) {
        this.password = password;
    }

    public User build() {
        return new User(id, name, email, password);
    }
}
