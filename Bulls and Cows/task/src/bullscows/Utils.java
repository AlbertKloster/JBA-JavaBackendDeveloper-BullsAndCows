package bullscows;

import java.util.*;

public class Utils {
    private static Scanner SC = new Scanner(System.in);

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

    public static String getSecretCode(int digits) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(String.valueOf(random.nextInt(9) + 1)); // first digit can not be 0
        for (int i = 0; i < digits - 1; ) {
            int digit = random.nextInt(10);
            if (builder.indexOf(String.valueOf(digit)) < 0) {
                i++;
                builder.append(digit);
            }
        }
        return builder.toString();
    }

    public static int getBulls(String secretCode, String number) {
        int bulls = 0;
        for (int i = 0; i < secretCode.length(); i++)
            if (secretCode.charAt(i) == number.charAt(i))
                bulls++;
        return bulls;
    }

    public static int getCows(String secretCode, String number) {
        int cows = 0;
        String secretCodeXorString = getXorString(secretCode, number);
        String numberXorString = getXorString(number, secretCode);
        for (char ch : numberXorString.toCharArray())
            if (secretCodeXorString.contains(String.valueOf(ch)))
                cows++;
        return cows;
    }

    private static String getXorString (String string, String refString) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < string.length(); i++)
            if (string.charAt(i) != refString.charAt(i))
                builder.append(string.charAt(i));
        return builder.toString();
    }

    public static void printResult(String secretCode, int bulls, int cows) {
        if (bulls == 0 && cows == 0)
            System.out.printf("Grade: None. The secret code is %s.\n", secretCode);
        else if (bulls == 0)
            System.out.printf("Grade: %d cow(s). The secret code is %s.\n", cows, secretCode);
        else if (cows == 0)
            System.out.printf("Grade: %d bull(s). The secret code is %s.\n", bulls, secretCode);
        else
            System.out.printf("Grade: %d bull(s) and %d cow(s). The secret code is %s.", bulls, cows, secretCode);
    }

}
