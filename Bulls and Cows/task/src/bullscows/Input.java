package bullscows;

import java.util.Scanner;

public class Input {

    private static final int MAX_CODE_LENGTH = 36;
    private static final Scanner SC = new Scanner(System.in);

    public static String getNumber(int codeLength) {
        String input = SC.nextLine();
        String regex = String.format("[0-9a-z]{%d}", codeLength);
        if (input.matches(regex))
            return input;
        else
            return null;
    }

    public static int getCodeLength() {
        String input = SC.nextLine();
        if (input.matches("\\d+")) {
            int codeLength = Integer.parseInt(input);
            if (codeLength > MAX_CODE_LENGTH)
                System.out.printf("Error: can't generate a secret code with a length of %s because there aren't enough unique symbols.", input);
            else
                return codeLength;
        }
        return -1;
    }

    public static int getNumberOfPossibleSymbols() {
        String input = SC.nextLine();
        if (input.matches("\\d+")) {
            int numberOfPossibleSymbols = Integer.parseInt(input);
            if (numberOfPossibleSymbols > MAX_CODE_LENGTH)
                System.out.printf("Error: can't generate a secret code with a length of %s because there aren't enough unique symbols.", input);
            else
                return numberOfPossibleSymbols;
        }
        return -1;
    }

}
