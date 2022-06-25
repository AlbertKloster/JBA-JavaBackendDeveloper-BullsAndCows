package bullscows;

public class Controller {

    public static void run() {
        System.out.println("Please, enter the secret code's length:");
        int codeLength = Input.getCodeLength();
        SecretCode secretCode = new SecretCode(codeLength);
        if (codeLength != -1)
            Game.start(secretCode.next());
    }

}
