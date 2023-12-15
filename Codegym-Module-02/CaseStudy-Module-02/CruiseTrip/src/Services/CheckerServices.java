package Services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckerServices {
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerLine = new Scanner(System.in);
    private Pattern pattern;
    private Matcher matcher;

    public static boolean checkConfirmByYesNo() {
        String customerInput = scannerLine.nextLine();
        boolean checkConfirm = false;
        while (!(customerInput.equalsIgnoreCase("y") || customerInput.equalsIgnoreCase("n"))) {
            System.err.println("Wrong input please try again.");
            customerInput = scannerLine.nextLine();
        }
        if (customerInput.equalsIgnoreCase("y")) {
            checkConfirm = true;
        }
        if (customerInput.equalsIgnoreCase("n")) {
            checkConfirm = false;
        }
        return checkConfirm;
    }

    public boolean checkEmail(String Email) {
        String EMAIL_REGEX = "^[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(Email);
        return matcher.matches();
    }

    public boolean checkNumber(String Number) {
        String TEL_REGEX = "^[0-9]{10,12}$";
        pattern = Pattern.compile(TEL_REGEX);
        matcher = pattern.matcher(Number);
        return matcher.matches();
    }

    public boolean checkExist(String Number, String Email) {
        try {
            FileReader fileReader = new FileReader("Customer.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String account;
            while ((account = bufferedReader.readLine()) != null) {
                if (account.contains(Number) || account.contains(Email)) {
                    System.out.println("The telnumber or email has been registered...please enter another");
                    return true;
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.out.println("File not found...please redirect to the right path");
        } catch (IOException ioe) {
            System.out.println("File cant read... please redirect the path");
        }
        return false;
    }

    public boolean checkPass(String Pass) {
        int PASSWORD_MIN_SIZE = 8;
        String PASSWORD_SPECIAL_CHARS = "@#$%^`<>&+=\"!#~%&',:;*/+-.=_\\[\\]\\(\\)\\|\\_\\?\\\\";
        String PASS_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[" + PASSWORD_SPECIAL_CHARS + "])(?=\\S+$).{" + PASSWORD_MIN_SIZE + ",}$";
        pattern = Pattern.compile(PASS_REGEX);
        matcher = pattern.matcher(Pass);
        return matcher.matches();
    }

    public boolean checkUAccount(String input) {
        try {
            FileReader fileReader = new FileReader("Customer.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String account;
            while ((account = bufferedReader.readLine()) != null) {
                if (account.contains(input)) {
                    return true;
                }
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println("Can not find the user...");
        } catch (IOException ioe) {
            System.err.println("File cant read... please redirect the path");
        }
        return false;
    }

    public boolean checkUPass(String UPass) {
        try {
            FileReader fileReader = new FileReader("Customer.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String account;
            boolean foundMatch = false;
            while ((account = bufferedReader.readLine()) != null) {
                if (account.contains(UPass)) {
                    foundMatch = true;
                    break;
                }
            }
            return foundMatch;
        } catch (FileNotFoundException fnfe) {
            System.out.println("Can not find the user...");
        } catch (IOException ioe) {
            System.out.println("File cant read... please redirect the path");
        }
        return false;
    }
}
