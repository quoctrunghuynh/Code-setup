package Services;

import Entity.Cruise.Cruise;
import Entity.Cruise.Room;
import Entity.Menus;
import Entity.Ticket;
import Entity.Users.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CustomerServices {
    private static final CustomerServices instance = new CustomerServices();
    private static final int CHECK_TEL = 1;
    private static final int CHECK_EMAIL = 2;
    private static final int CHECK_PASS = 3;
    private static final int CHECK_U_ACCOUNT = 4;
    private static final int MENU_SIGN_IN = 1;
    private static final int MENU_SIGN_UP = 2;
    private static final int MENU_BROWSE = 3;
    private static final int LOGOUT = 2;
    private static final int CUSTOMER_BROWSE = 1;
    public static Customer currentCustomer;
    static int cruisePosition;
    private static Scanner scannerInt = new Scanner(System.in);
    private static Scanner scannerString = new Scanner(System.in);
    private CustomerServices() {
    }

    public static CustomerServices getInstance() {
        return instance;
    }

    public static void userSelect() {
        final int MIN = 1;
        final int MAX = 3;
        try {
            int option;
            while (true) {
                option = scannerInt.nextInt();
                if ((option <= MAX) && (option >= MIN)) {
                    break;
                }
                System.out.println("Wrong input, please try again.");
            }
            switch (option) {
                case MENU_SIGN_IN -> signIn();
                case MENU_SIGN_UP -> signUp();
                case MENU_BROWSE -> browse();
            }
        } catch (InputMismatchException ime) {
            System.out.println("Wrong input, please try again.");
            userSelect();
        }
    }

    public static void signIn() {
        if (currentCustomer == null) {
            System.out.println();
            System.out.println("----SIGN IN----");
            System.out.println("Enter your email or your phone number: ");
            String input = scannerString.nextLine();
            if (check(CHECK_U_ACCOUNT, input)) {
                try {
                    FileReader fr = new FileReader("Customer.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String getAccount;
                    while ((getAccount = br.readLine()) != null) {
                        if (getAccount.contains(input)) {
                            System.out.println("Sign in success");
                            currentCustomer = getCurrentCustomer(getAccount.split(":"));
                        }
                    }
                } catch (FileNotFoundException fnfe) {
                    System.out.println("Can not find the source file to check current Customer");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                signIn();
            }
        } else {
            System.out.println("You already signed In...want to log out?(Y/N)");
            String select = scannerString.nextLine();
            while (!(select.equalsIgnoreCase("y") || select.equalsIgnoreCase("n"))) {
                System.out.println("Wrong input please try again.");
                select = scannerString.nextLine();
            }
            if (select.equalsIgnoreCase("y")) {
                currentCustomer = null;
            } else if (select.equalsIgnoreCase("n")) {
                System.out.println("Continue...");
                return;
            }
        }
        Menus.showCustomerMenu();
        customerOption();
    }

    private static void customerOption() {
        final int MIN = 1;
        final int MAX = 2;
        try {
            int option = scannerInt.nextInt();
            while (option > MAX || option < MIN) {
                System.out.println("Wrong input, please try again.");
                option = scannerInt.nextInt();
            }
            switch (option) {
                case CUSTOMER_BROWSE -> browse();
                case LOGOUT -> {
                    currentCustomer.logout();
                    Menus.showBasicMenu();
                    userSelect();
                }

            }
        } catch (InputMismatchException ime) {
            System.out.println("Wrong input, please try again.");
            userSelect();
        }
    }

    public static void signUp() {
        System.out.println("----> Sign UP <----");
        CheckerServices checkerServices = new CheckerServices();

        System.out.print("Enter your first name: ");
        String firstName = scannerString.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scannerString.nextLine();

        System.out.print("Enter your telephone number: ");
        String telephone = scannerString.nextLine();

        System.out.print("Enter your email: ");
        String email = scannerString.nextLine();
        check(CHECK_TEL, telephone);
        check(CHECK_EMAIL, email);
        if (checkerServices.checkExist(telephone, email)) {
            return;
        } else {
            System.out.println("Telephone and email valid, continue creating customer");
        }

        Menus.showPasswordContent();
        String password = scannerString.nextLine();
        check(CHECK_PASS, password);

        System.out.println("Creating account for user: " + firstName);
        createUser(firstName, lastName, telephone, email, password);
        Menus.showCustomerMenu();
        customerOption();
    }

    public static void browse() {
        final int EXIT = 0;
        final int MAX = 4;
        final int MIN = 1;
        final int BOOK = 1;
        final int DEALS = 2;
        final int TRIPS = 3;
        final int SHOW_TICKET = 4;
        //Deal Case
        final int DEAL1 = 1;
        //Trips Case
        final int SEARCH_BY_PRICE = 1;
        Menus.showBrowseMenu();
        try {
            int option = scannerInt.nextInt();
            while (option > MAX || option < MIN) {
                System.out.println("Wrong input, please try again.");
                option = scannerInt.nextInt();
            }
            switch (option) {
                case BOOK -> {
                    customerBooking();
                }
                case DEALS -> {
                    Menus.showDeals();
                    option = scannerInt.nextInt();
                    switch (option) {
                        case DEAL1 -> CustomerServices.getDealBooking1();
                        case EXIT -> browse();
                    }

                }
                case TRIPS -> {
                    Menus.showTripMenu();
                    option = scannerInt.nextInt();
                    switch (option) {
                        case SEARCH_BY_PRICE: {
                            CruiseServices.getInstance().showCruiseList();
                            customerSelectTrip();
                            RoomServices.updateDateRoomPrice();
                            System.out.println("Do you want to book?(Y/N)");
                            if (CheckerServices.checkConfirmByYesNo()) {
                                customerBooking();
                            }
                        }
                        case 2: {
                            CruiseServices.getInstance().showDestination();
                            CruiseServices.getInstance().searchTripByName();
                        }
                        case EXIT:
                            browse();
                    }
                }
                case SHOW_TICKET -> {
                    if (currentCustomer == null) {
                        customerLoginToContinue();
                    }
                    TicketServices.getCurrentCustomerTicket();
                }
            }
        } catch (InputMismatchException ime) {
            System.out.println("Wrong input, please try again.");
            browse();
        }
    }

    private static void customerBooking() {
        if (currentCustomer == null) {
            customerLoginToContinue();
        }
        CruiseServices.getInstance().showCruiseList();
        customerSelectTrip();
        Cruise.showCurrentCruiseRoomList();
        customerSelectRoom();
        browse();
    }

    private static void getDealBooking1() {
        final int limitToActivateDeal = 3;
        System.out.println("""
                |----------------------->Please notice this<-----------------------|\s
                |   In this deal:                                                  |
                |   -You must buy 3 trip to meet the condition                     |
                |   -You can get 1 junior room type FREE.                          |
                |                                                                  |
                |          ***__Shall we continue to get your room?__***           |
                |_______________________________________________________(Y/N)______|""");
        if (currentCustomer == null) {
            customerLoginToContinue();
            CruiseServices.getInstance().showCruiseList();
            System.out.println("Please select 1 of our cruise to continue");
            customerSelectTrip();
            Cruise.showCurrentCruiseRoomList();
            for (int ticket = 0; ticket < limitToActivateDeal; ) {
                System.out.println("Your purchased " + ticket + " you need to purchased " + (limitToActivateDeal - ticket) + " more to get discount");
                customerSelectRoom();
                ticket++;
            }
            System.out.println("Choose your free junior room: ");
            RoomServices.getInstance().showRoomListByType("Junior");
            customerSelectFreeRoom();
        } else {
            CruiseServices.getInstance().showCruiseList();
            System.out.println("Please select 1 of our cruise to continue");
            customerSelectTrip();
            Cruise.showCurrentCruiseRoomList();
            for (int ticket = 0; ticket < limitToActivateDeal; ) {
                System.out.println("Your purchased " + ticket + " you need to purchased " + (limitToActivateDeal - ticket) + " more to get discount");
                customerSelectRoom();
                ticket++;
            }
            System.out.println("Choose your free junior room: ");
            RoomServices.getInstance().showRoomListByType("Junior");
            customerSelectFreeRoom();
        }
    }

    private static void customerSelectFreeRoom() {
        System.out.print("Select your room by enter room number: ");
        String roomID;
        while (true) {
            roomID = scannerString.nextLine();
            if (roomID.length() != 4) {
                System.out.println("Wrong input...");
            } else {
                break;
            }
        }
        for (Room room : CruiseServices.currentCruise.getRoomList()) {
            if (room.getRoom_Id().equals(roomID) && room.getRoom_Type().equals("Junior")) {
                RoomServices.currentRoom = room;
            }
        }
        setCustomerFreeTicket(RoomServices.currentRoom.getRoom_Id(), CruiseServices.currentCruise.getName());
    }

    protected static void customerLoginToContinue() {
        System.out.println("To continue this process, login is a must, do you have an account?(Y/N)");
        if (CheckerServices.checkConfirmByYesNo()) {
            signIn();
        } else {
            signUp();
        }
    }

    private static void customerSelectTrip() {
        System.out.print("Select cruise by enter number ID: ");
        int index = scannerInt.nextInt();
        cruisePosition = index - 1;
        try {
            while (cruisePosition > CruiseServices.cruiseList.size() || cruisePosition < 1) {
                System.out.println("Wrong input, please try again");
                customerSelectTrip();
            }
        } catch (InputMismatchException inputMismatchException) {
            System.err.println("Wrong input, please try again");
            customerSelectTrip();
        }
        CruiseServices.currentCruise = CruiseServices.cruiseList.get(cruisePosition);
    }

    private static void customerSelectRoom() { //Must have customerSelectTrip run before
        System.out.print("Select your room by enter room number: ");
        String roomID = scannerString.nextLine();
        ArrayList<Room> roomList = CruiseServices.currentCruise.getRoomList();
        getCustomerRoomOrder(roomID, roomList);
    }

    private static void getCustomerRoomOrder(String roomID, ArrayList<Room> roomList) {
        for (Room room : roomList) {
            if (room.getRoom_Id().equals(roomID)) {
                RoomServices.currentRoom = room;

                if (RoomServices.currentRoom.isAvailable()) {
                    System.out.println(room.showRoomInfo());
                    System.out.println("Do you want to book this room? Y/N");

                    if (CheckerServices.checkConfirmByYesNo()) {
                        room.setCustomerInfo(currentCustomer);
                        RoomServices.getInstance().setAvailableOnList(cruisePosition, roomID);
                        setCustomerTicket(roomID, CruiseServices.currentCruise.getName());
                        RoomServices.getInstance().updateRoomListOnCSV(cruisePosition);
                    } else {
                        customerSelectRoom();
                    }
                } else {
                    System.out.println("This room currently not available");
                    customerSelectRoom();
                }
                return;
            }
        }
        customerSelectRoom();
    }

    private static void setCustomerTicket(String roomID, String shipName) {
        String customerInfoTail = currentCustomer.getTelephone();
        String customerURL = "CustomerTicket/Customer" + customerInfoTail + ".txt";
        try {
            FileOutputStream fos = new FileOutputStream(customerURL, true);
            DataOutputStream dos = new DataOutputStream(fos);
            Ticket ticket = new Ticket();
            dos.writeBytes(ticket.toString());
            System.out.println("Create ticket: " + TicketServices.createTicketId());
        } catch (IOException ioe) {
            System.err.println("Cant find file.");
        }
    }

    private static void setCustomerFreeTicket(String roomID, String shipName) {
        String customerInfoTail = currentCustomer.getTelephone();
        String customerURL = "CustomerTicket/Customer" + customerInfoTail + ".txt";
        try {
            FileOutputStream fos = new FileOutputStream(customerURL, true);
            DataOutputStream dos = new DataOutputStream(fos);
            Ticket ticket = new Ticket();
            Ticket.setPriceFree();
            dos.writeBytes(ticket.toString());
            System.out.println("Create ticket: " + TicketServices.createTicketId());
        } catch (IOException ioe) {
            System.err.println("Cant find file.");
        }
    }

    private static boolean check(int option, String input) {
        CheckerServices checkerServices = new CheckerServices();
        boolean result = false;
        switch (option) {
            case CHECK_TEL -> {
                result = checkerServices.checkNumber(input);
                if (result) {
                    System.out.println("Tel number is valid");
                } else {
                    System.out.println("Wrong tel number format");
                    signUp();
                }
            }
            case CHECK_EMAIL -> {
                result = checkerServices.checkEmail(input);
                if (result) {
                    System.out.println("Email is valid");
                } else {
                    System.out.println("Wrong email format");
                    signUp();
                }
            }
            case CHECK_PASS -> {
                result = checkerServices.checkPass(input);
                if (result) {
                    System.out.println("Password is strong");
                } else {
                    System.out.println("Password is not strong");
                    signUp();
                }
            }
            case CHECK_U_ACCOUNT -> {
                boolean resultCheckAccount;
                boolean resultCheckPass;
                resultCheckAccount = checkerServices.checkUAccount(input);
                System.out.println("Enter your password: ");
                Scanner scanner = new Scanner(System.in);
                String Upass = scanner.nextLine();
                resultCheckPass = checkerServices.checkUPass(Upass);
                if (!(resultCheckAccount && resultCheckPass)) {
                    System.out.println("Wrong username or password");
                    System.out.println("Please try again");
                } else {
                    System.out.println("Login successfully!!!");
                    result = true;
                }
            }
        }
        return result;
    }

    private static void createUser(String firstName, String lastName, String number, String email, String password) {
        String customerList = "Customer.txt";
        try {
            FileOutputStream fos = new FileOutputStream(customerList, true);
            DataOutputStream dot = new DataOutputStream(fos);
            Customer customer = Customer.builder()
                    .id(getNewId())
                    .firstName(firstName)
                    .lastName(lastName)
                    .telephone(number)
                    .email(email)
                    .password(password)
                    .build();
            dot.writeBytes(customer.toString());
            System.out.println("Created customer success");
            currentCustomer = customer;
            fos.close();
            dot.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int getNewId() {
        int newId = 1;
        try {
            FileReader fileReader = new FileReader("Customer.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.readLine() != null) {
                newId++;
            }
        } catch (IOException ioe) {
            System.out.println("IOException appeared...");
        } catch (NullPointerException npe) {
            System.out.println("NullPointerException appeared...");
        }
        return newId;
    }

    private static Customer getCurrentCustomer(String[] customerInfoList) {
        if (currentCustomer == null) {
            System.out.println("Hello " + customerInfoList[2]);
            currentCustomer = Customer.builder()
                    .id(Integer.parseInt(customerInfoList[1]))
                    .firstName(customerInfoList[2])
                    .lastName(customerInfoList[3])
                    .email(customerInfoList[4])
                    .telephone(customerInfoList[5])
                    .password(customerInfoList[6])
                    .build();
        }
        return currentCustomer;
    }
}