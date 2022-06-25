package bullscows;

import java.util.Scanner;

public class Input {

    private static final Scanner SC = new Scanner(System.in);

    public static String getNumber(int digits) {
        String input = SC.nextLine();
        String regex = String.format("\\d{%d}", digits);
        if (input.matches(regex))
            return input;
        else
            return null;
    }

    public static int getCodeLength() {
        String input = SC.nextLine();
        if (input.matches("\\d"))
            return Integer.parseInt(input);
        else {
            System.out.printf("Error: can't generate a secret number with a length of %s because there aren't enough unique digits.", input);
            return -1;
        }
    }

}
