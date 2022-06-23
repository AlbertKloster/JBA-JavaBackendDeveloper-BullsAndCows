package bullscows;

import java.util.Scanner;

public class Utils {
    private static Scanner SC = new Scanner(System.in);

    public static int getInt() {
        String input = SC.nextLine();
        if (input.matches("\\d{4}"))
            return Integer.parseInt(input);
        else
            return -1;
    }
}
