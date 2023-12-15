import java.util.Scanner;

public class DocSoThanhChu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the input: ");
        int input = scanner.nextInt();
        int hundred = input / 100;
        int tens = (input - hundred * 100) / 10;
        int unit = input % 10;


        String text = "";
        if (input >= 1000) {
            System.out.println("******Error, please enter the input below 1000******");
        }
        else {
            if (input > 100) {
                text += hundred(text, hundred);

                if (tens == 1) {
                    text += "and ";
                    text = teen(text, unit);
                    System.out.println(text);
                } else {
                    text += "and ";
                    text = tens(text, tens);
                    text = ones(text, unit);
                    System.out.println(text);
                }
            }
            if (input < 100) {
                if (tens == 1) {
                    text = teen(text, unit);
                    System.out.println(text);
                } else {
                    text = tens(text, tens);
                    text = ones(text, unit);
                    System.out.println(text);
                }
            }
        }
    }

    private static String hundred(String text, int hundred) {
        switch (hundred) {
            case 1 -> text += "One hundred ";
            case 2 -> text += "Two hundred ";
            case 3 -> text += "Three hundred ";
            case 4 -> text += "Four hundred ";
            case 5 -> text += "Five hundred ";
            case 6 -> text += "Six hundred ";
            case 7 -> text += "Seven hundred ";
            case 8 -> text += "Eight hundred ";
            case 9 -> text += "Nine hundred ";
        }
        return text;
    }
    private static String teen(String text, int unit) {
        switch (unit) {
            case 1 -> text += "Eleven ";
            case 2 -> text += "Twelve ";
            case 3 -> text += "Thirteen ";
            case 4 -> text += "Fourteen ";
            case 5 -> text += "Fifteen ";
            case 6 -> text += "Sixteen ";
            case 7 -> text += "Seventeen ";
            case 8 -> text += "Eighteen ";
            case 9 -> text += "Nineteen ";
        }
        return text;
    }
    private static String ones(String text, int unit){
        switch (unit) {
            case 0 -> text += " ";
            case 1 -> text += "one ";
            case 2 -> text += "two ";
            case 3 -> text += "three ";
            case 4 -> text += "four ";
            case 5 -> text += "five ";
            case 6 -> text += "six ";
            case 7 -> text += "seven ";
            case 8 -> text += "eight ";
            case 9 -> text += "nine ";
        }
        return text;
    }
    private static String tens(String text, int tens) {
        switch(tens){
            case 2 -> text += "Twenty ";
            case 3 -> text += "Thirty ";
            case 4 -> text += "Forty ";
            case 5 -> text += "Fifty ";
            case 6 -> text += "Sixty ";
            case 7 -> text += "Seventy ";
            case 8 -> text += "Eighty ";
            case 9 -> text += "Ninety ";
        }
        return text;
    }
}
