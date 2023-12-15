package entity;

import java.util.Arrays;

public class User {
    private int user_ID;
    private String user_Name;
    private String password;
    private String phone;

    private String[] address;

    public User(){

    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    public User(int user_ID, String user_Name, String password, String phone, String[] address) {
        this.user_ID = user_ID;
        this.user_Name = user_Name;
        this.password = password;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_ID=" + user_ID +
                ", user_Name='" + user_Name + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", address=" + Arrays.toString(address) +
                '}';
    }
}
