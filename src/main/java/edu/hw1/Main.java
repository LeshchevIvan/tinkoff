<<<<<<< HEAD
public class Main {

    public static void main(String[] args) {
        //Task_0
        System.out.print("Task_0: ");
        LOGGER.info();

        //Task_1
        System.out.println("Task_1: " + task1.minutesToSeconds("12:30"));

        //Task_2
        System.out.println("Task_2: " + task2.countDigits(123));

        //Task_3
        float[] a1 = {1, 2, 3, 4};
        float[] a2 = {2, 3};
        System.out.println("Task_3: " + task3.isNestable(a1, a2));

        //Task_4
        System.out.println("Task_4: " + task4.fixString("ad"));

        //Task_5
        System.out.println("Task_5: " + task5.isPalindromeDescendant(344));

        //Task_6
        System.out.println("Task_6: " + task6.countK(1234));

        //Task_7
        System.out.println("Task_7_1: " + task7.rotateRight(8, 1));
        System.out.println("Task_7_2: " + task7.rotateLeft(17, 2));

        //Task_8
        int[][] arr = new int[][]{
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("Task_8: " + task8.knightBoardCapture(arr));

=======
package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public final class Main {
    private final static Logger LOGGER = LogManager.getLogger();

    private Main() {
    }

    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        LOGGER.info("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 0; i <= 2; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            LOGGER.info("i = {}", i);
        }
>>>>>>> origin/main
    }
}
