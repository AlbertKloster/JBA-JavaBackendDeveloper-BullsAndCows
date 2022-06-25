package bullscows;

import java.util.Random;

public class SecretCode {

    private final int ASCII_ZERO = 48;
    private final int ASCII_A_SMALL = 97;

    private final int codeLength;
    private final int numberOfPossibleSymbols;

    public SecretCode(int codeLength, int numberOfPossibleSymbols) {
        this.codeLength = codeLength;
        this.numberOfPossibleSymbols = numberOfPossibleSymbols;
    }

    public String next() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < codeLength; ) {
            int digit = random.nextInt(numberOfPossibleSymbols);
            char symbol = getSymbol(digit);
            if (isNotPresent(builder, symbol)) {
                i++;
                builder.append(symbol);
            }
        }
        return builder.toString();
    }

    private char getSymbol(int digit) {
        return (char) (digit + (digit < 10 ? ASCII_ZERO : ASCII_A_SMALL - 10));
    }

    private boolean isNotPresent(StringBuilder builder, int digit) {
        return builder.indexOf(String.valueOf((char)digit)) < 0;
    }

}
