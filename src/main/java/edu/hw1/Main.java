package edu.hw1;
public class Main {

    public static void main(String[] args) {
        //Task_0
        System.out.print("Task_0: ");
        Logger.info();

        //Task_1
        System.out.println("Task_1: " + Task1.minutesToSeconds("1:60"));

        //Task_2
        System.out.println("Task_2: " + Task2.countDigits(123456789));

        //Task_3
        float[] a1 = {1, 2, 3, 4};
        float[] a2 = {2, 3};
        System.out.println("Task_3: " + Task3.isNestable(a1, a2));

        //Task_4
        System.out.println("Task_4: " + Task4.fixString("ad"));

        //Task_5
        System.out.println("Task_5: " + Task5.isPalindromeDescendant(144));

        //Task_6
        System.out.println("Task_6: " + Task6.countK(1234));

        //Task_7
        System.out.println("Task_7_1: " + Task7.rotateRight(8, 1));
        System.out.println("Task_7_2: " + Task7.rotateLeft(17, 2));

        //Task_8
        int[][] arr = new int[][] {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };
        System.out.println("Task_8: " + Task8.knightBoardCapture(arr));

    }
}
