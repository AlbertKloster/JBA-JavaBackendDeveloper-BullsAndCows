package bullscows;

public class Game {
    public static void start(String secretCode) {
        System.out.println("Okay, let's start a game!");
        int turn = 1;
        while (true) {
            System.out.printf("Turn %d :\n", turn++);
            if (guess(secretCode)) {
                System.out.println("Congratulations! You guessed the secret code.");
                return;
            }
        }
    }

    private static boolean guess(String secretCode) {
        String number = Input.getNumber(secretCode.length());
        int bulls = getBulls(secretCode, number);
        int cows = getCows(secretCode, number);
        System.out.println(getMessage(secretCode, bulls, cows));
        return secretCode.length() == bulls;
    }

    private static int getBulls(String secretCode, String number) {
        int bulls = 0;
        for (int i = 0; i < secretCode.length(); i++)
            if (secretCode.charAt(i) == number.charAt(i))
                bulls++;
        return bulls;
    }

    private static int getCows(String secretCode, String number) {
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

    private static String getMessage(String secretCode, int bulls, int cows) {
        if (bulls == 0 && cows == 0)
            return "Grade: None.";
        if (cows == 0)
            return String.format("Grade: %d bull%s", bulls, bulls == 1 ? "" : "s");
        if (bulls == 0)
            return String.format("Grade: %d cow%s", cows, cows == 1 ? "" : "s");
        return String.format("Grade: %d bulls and %d cow", bulls, cows);
    }

}
