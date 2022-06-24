package bullscows;


import static bullscows.Utils.*;

public class Main {
    public static void main(String[] args) {
        int codeLength = getCodeLength();
        if (codeLength > 0) {
            String secretCode = getSecretCode(codeLength);
            System.out.printf("The random secret number is %s.", secretCode);
        }
    }
}
