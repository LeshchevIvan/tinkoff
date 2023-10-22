import java.util.Scanner;

class ConsoleHangman {
    static Scanner scanner = new Scanner(System.in);

    public static void run() {
        System.out.println("Hi, it's a ConsoleHangman game.\n" +
                "If you are ready to play insert 1\n" +
                "If you are want to exit insert 0");
        char userAnswer = scanner.next().charAt(0);
        do {
            if (userAnswer == '1') {
                Session round = new Session();
                round.guess();
                System.out.println("If you want to play again insert 1\n" +
                        "Want to exit insert 0 ");
                userAnswer = scanner.next().charAt(0);
            }

        } while (userAnswer == '1');
    }
}