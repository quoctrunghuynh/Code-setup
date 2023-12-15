package Entity;

import static Services.CustomerServices.currentCustomer;

public class Menus {
    private static void Greeting() {
        if (currentCustomer != null) {
            System.out.println("-----> Welcome " + currentCustomer.getFirstName() + " to The 7 Sailors <-----");
        } else {
            System.out.println("-----> Welcome to The 7 Sailors <-----");
        }
    }

    private static void Content() {
        System.out.println("""
                -----> Welcome to The 7 Sailors <-----
                1. Sign in.
                2. Sign up.
                3. Browse.
                Select your option...""");
    }

    private static void PasswordContent() {
        System.out.println("""
                -----> CREATE PASSWORD <-----
                Password must have at least 8 characters and:
                1.  A digit must occur at least 1.
                2.  A lower case letter must occur at least 1.
                3.  An upper case letter must occur at least 1.
                4.  A special character must occur at least 1.
                5.  No whitespace allowed in the entire string.
                Enter your password:""");
    }

    private static void CustomerMenu() {
        Greeting();
        System.out.println("""
                1. Browse.
                2. Log out.
                Select your option""");
    }

    public static void showBasicMenu() {
        Content();
    }

    public static void showCustomerMenu() {
        CustomerMenu();
    }

    public static void showPasswordContent() {
        PasswordContent();
    }

    public static void Destination() {
        Greeting();
        System.out.println("""
                1.Vịnh Hạ Long
                2.Vịnh Lan Hạ
                3.Nha Trang
                4.Phú Quốc""");
    }

    public static void showBrowseMenu() {
        System.out.println("""
                1. Book.
                2. Deal, discount.
                3. Trip.
                4. View your ticket""");
    }

    public static void showTripMenu() {
        System.out.println("""
                What are you looking for?
                1. Search by price.
                2. Search by end Destination""");
    }

    public static void showDeals() {
        System.out.println("""
                1. Book 4 free 1
                0. Exit""");
    }
}
