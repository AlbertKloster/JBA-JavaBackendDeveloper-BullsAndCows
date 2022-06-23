package bullscows;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        System.out.println("The secret code is prepared: ****.");
        Random random = new Random();
        int secretCode = 1000;
        for (int i = 0; i < 2; i++) {
            secretCode = random.nextInt(10000 - 1000) + 1000;
            System.out.printf("\nTurn %d. Answer:\n", i + 1);
            System.out.println(secretCode);
            System.out.printf("Grade: %d bulls.\n", 4 * i);
        }
        System.out.printf("Congrats! The secret code is %d.\n", secretCode);

    }
}
