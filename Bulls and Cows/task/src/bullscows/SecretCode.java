package bullscows;

import java.util.Random;

public class SecretCode {

    private int codeLength;

    public SecretCode(int codeLength) {
        this.codeLength = codeLength;
    }

    public int getCodeLength() {
        return codeLength;
    }

    public void setCodeLength(int codeLength) {
        this.codeLength = codeLength;
    }

    public String next() {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(nextInt(codeLength == 1 ? 0 : 1, 10)); // first digit can not be 0
        for (int i = 0; i < codeLength - 1; ) {
            int digit = random.nextInt(10);
            if (isNotPresent(builder, digit)) {
                i++;
                builder.append(digit);
            }
        }
        return builder.toString();
    }

    private String nextInt(int min, int max) {
        Random random = new Random();
        return String.valueOf(random.nextInt(max - min) + min);
    }

    private boolean isNotPresent(StringBuilder builder, int digit) {
        return builder.indexOf(String.valueOf(digit)) < 0;
    }

}
