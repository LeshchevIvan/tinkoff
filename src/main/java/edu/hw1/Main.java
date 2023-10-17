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

    }
}
