import java.util.Arrays;
import java.util.Scanner;

public class Session {
    private int attempt = 0;
    private final int maxAttempts = 5;
    private final char[] word = Dictionary.randomWord();
    private boolean isCorrectAnswer = false;
    private char[] currentState = new char[word.length];


    Scanner scanner = new Scanner(System.in);

    public void guess() {
        for (int i = 0; i < currentState.length; i++) {
            currentState[i] = '*';
        }
        while (attempt != maxAttempts) {
            System.out.println("Guess a letter:");
            String userAnswer = scanner.nextLine();
            if(userAnswer.length()==1) {
                if (userAnswer.charAt(0) == '-') {
                    System.out.println("Good luck next time!");
                    System.out.println("The word was: " + String.valueOf(word));
                    System.out.println();
                    break;
                }
                for (int i = 0; i < word.length; i++) {
                    if (word[i] == userAnswer.charAt(0)) {
                        currentState[i] = word[i];
                        isCorrectAnswer = true;
                    }


                }
                if (isCorrectAnswer) {
                    if (Arrays.equals(word, currentState)) {
                        System.out.println("You won!");
                        System.out.println("The word is: " + String.valueOf(currentState));
                        break;
                    } else {
                        System.out.println("Hit!");
                        System.out.println("The word is: " + String.valueOf(currentState));
                    }
                } else {
                    attempt++;
                    if (attempt == maxAttempts) {
                        System.out.println("You lost!");
                        System.out.println("The word was: " + String.valueOf(word));
                    } else {
                        System.out.println(String.format("Missed, mistake %d out of %d.", attempt, maxAttempts));
                        System.out.println("The word is: " + String.valueOf(currentState));
                    }
                }
                System.out.println();
                isCorrectAnswer = false;
            }
            else {
                System.out.println("I think you make a mistake, try again.\n\n");
            }
        }
    }
}
