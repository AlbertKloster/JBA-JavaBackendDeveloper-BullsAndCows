package bullscows;

public class Controller {
    private static final int ASCII_A_SMALL = 97;

    public static void run() {
        System.out.println("Input the length of the secret code:");
        int codeLength = Input.getCodeLength();
        if (codeLength == -1)
            return;
        System.out.println("Input the number of possible symbols in the code:");
        int numberOfPossibleSymbols = Input.getNumberOfPossibleSymbols();
        if (numberOfPossibleSymbols == -1)
            return;
        if (codeLength == 0)
            System.out.println("Error: code length should be more than 0.");
        else if (codeLength > numberOfPossibleSymbols) {
            System.out.printf("Error: it's not possible to generate a code with a length of %d with %d unique symbols.",
                    codeLength, numberOfPossibleSymbols);
        } else {
            SecretCode secretCode = new SecretCode(codeLength, numberOfPossibleSymbols);
            printMessage(codeLength, numberOfPossibleSymbols);
            Game.start(secretCode.next());
        }
    }

    private static void printMessage(int codeLength, int numberOfPossibleSymbols) {
        System.out.printf("The secret is prepared: %s %s.\n", getAsterisks(codeLength), getSymbols(numberOfPossibleSymbols));
    }

    private static String getAsterisks(int codeLength) {
        return "*".repeat(codeLength);
    }

    private static String getSymbols(int numberOfPossibleSymbols) {
        StringBuilder builder = new StringBuilder("(0-");
        builder.append(Math.min(9, numberOfPossibleSymbols));
        if (numberOfPossibleSymbols > 10)
            builder.append(getLetters(numberOfPossibleSymbols));
        builder.append(")");
        return builder.toString();
    }

    private static String getLetters(int numberOfPossibleSymbols) {
        return ", a" + (numberOfPossibleSymbols > 11 ? "-" + (char)(numberOfPossibleSymbols - 11 + ASCII_A_SMALL) : "");
    }

}
