package bullscows;


import static bullscows.Utils.*;

public class Main {
    public static void main(String[] args) {
        String secretCode = getSecretCode(4);
        String number = getInt(4);
        int bulls = getBulls(secretCode, number);
        int cows = getCows(secretCode, number);
        printResult(secretCode, bulls, cows);
    }
}
