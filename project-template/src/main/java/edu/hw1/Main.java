import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;


public class Main {
    //Task_1 func
    public static int minutesToSeconds(@NotNull String time) {
        String[] time_array;
        char[] correct_symbols = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        time_array = time.split(":");
        int minutes = 0;
        int seconds = 0;
        int mul = 1;
        boolean IsCorrect = false;
        if (time_array.length == 2) {
            char[] temp = time_array[0].toCharArray();
            for (int i = temp.length - 1; i >= 0; i--) {
                for (var correct_symbol : correct_symbols) {
                    if (temp[i] == correct_symbol) {
                        minutes += Character.getNumericValue(temp[i]) * mul;
                        mul *= 10;
                        IsCorrect = true;
                        break;
                    } else IsCorrect = false;
                }
                if (!IsCorrect) break;
            }

            temp = time_array[1].toCharArray();
            mul = 1;

            if (temp.length == 2 && IsCorrect && temp[0] != '6') {
                for (int i = temp.length - 1; i >= 0; i--) {
                    for (var correct_symbol : correct_symbols) {
                        if (temp[i] == correct_symbol) {
                            seconds += Character.getNumericValue(temp[i]) * mul;
                            mul *= 10;
                            IsCorrect = true;
                            break;
                        } else IsCorrect = false;
                    }
                    if (!IsCorrect) break;
                }
            } else IsCorrect = false;


        }
        int ans = minutes * 60 + seconds;
        if (IsCorrect) return ans;
        else return -1;
    }

    //Task_2 func
    public static int countDigits(Integer number) {
        number = Math.abs(number);
        int reducer = 1;
        int ans = 0;
        int[] arr = new int[10];

        if (number < 10) ans = 1;
        else if (number.equals(10)) ans = 2;
        else {
            while (reducer <= number) {
                for (int i = 0; i < 10; i++) {
                    if (number % (10 * reducer) == 0) {
                        reducer *= 10;
                        arr[i] += 1;
                        break;
                    } else {
                        number -= reducer;
                    }
                }
            }
        }
        for (int i : arr) {
            if (i != 0) ans += i;
        }
        return ans;
    }

    //Task_3 func
    public static boolean isNestable(float @NotNull [] a1, float @NotNull [] a2) {
        float min_a1 = a1[0];
        float min_a2 = a2[0];
        float max_a1 = a1[0];
        float max_a2 = a2[0];

        for (var el : a1) {
            if (el < min_a1) min_a1 = el;
            if (el > max_a1) max_a1 = el;
        }
        for (var el : a2) {
            if (el < min_a2) min_a2 = el;
            if (el > max_a2) max_a2 = el;
        }
        return min_a1 > min_a2 && max_a1 < max_a2;
    }

    //Task_4 func
    public static @NotNull String fixString(String text) {
        char[] ans = text.toCharArray();
        int len = ans.length;
        char buf;

        if (len % 2 == 0) {
            for (int i = 0; i < len - 1; i += 2) {
                buf = ans[i];
                ans[i] = ans[i + 1];
                ans[i + 1] = buf;
            }
        } else if (len != 1) {
            for (int i = 0; i < len - 2; i += 2) {
                buf = ans[i];
                ans[i] = ans[i + 1];
                ans[i + 1] = buf;
            }
        } else return text;
        return String.valueOf(ans);
    }

    //Task_5 func
    public static boolean isPalindromeDescendant(Integer number) {
        boolean isPalindrome = false;
        char[] arr_num;
        int len;
        number = Math.abs(number);


        while (!isPalindrome && number > 10) {

            arr_num = (number.toString()).toCharArray();
            len = arr_num.length;
            //CHECK PALINDROME
            if (len % 2 == 0) {
                char[] arr1 = new char[len / 2];
                char[] arr2 = new char[len / 2];
                for (int i = 0; i < len / 2; i++) {
                    arr1[i] = arr_num[i];
                }
                int k = 0;
                for (int i = len - 1; i > len / 2 - 1; i--) {
                    arr2[k] = arr_num[i];
                    k++;
                }
                if (Arrays.equals(arr1, arr2)) {
                    isPalindrome = true;
                    break;
                }
            } else {
                char[] arr1 = new char[len / 2];
                char[] arr2 = new char[len / 2];
                for (int i = 0; i < len / 2; i++) {
                    arr1[i] = arr_num[i];
                }
                int k = 0;
                for (int i = len - 1; i > len / 2; i--) {
                    arr2[k] = arr_num[i];
                    k++;
                }
                if (Arrays.equals(arr1, arr2)) {
                    isPalindrome = true;
                    break;
                }
            }
            //FIND Descendant
            if (!isPalindrome) {
                if (len >= 2) {
                    if (len % 2 == 0) {
                        int[] buf = new int[len / 2];
                        int index = 0;
                        for (int i = 0; i < len - 1; i += 2) {
                            buf[index] += ((int) arr_num[i] - '0' + (int) arr_num[i + 1] - '0');
                            index += 1;
                        }
                        number = 0;
                        int mul = 1;
                        for (int i = len / 2 - 1; i >= 0; i--) {
                            number += buf[i] * mul;
                            mul *= 10;
                        }

                    } else {
                        int[] buf = new int[len / 2 + 1];
                        int index = 0;
                        for (int i = 0; i < len - 2; i += 2) {
                            buf[index] += ((int) arr_num[i] - '0' + (int) arr_num[i + 1] - '0');
                            index += 1;
                        }
                        buf[index] = (int) arr_num[len - 1] - '0';
                        number = 0;
                        int mul = 1;
                        for (int i = len / 2; i >= 0; i--) {
                            number += buf[i] * mul;
                            mul *= 10;
                        }
                    }
                }
            }
        }
        return isPalindrome;
    }

    //Task_6 func
    public static int countK(Integer n) {
        if (n == 6174) return 1;
        char[] arrayNum = n.toString().toCharArray();
        char firstNumber = arrayNum[0];
        boolean onlyOneNumber = true;
        for (char i : arrayNum) {
            if (firstNumber != i) {
                onlyOneNumber = false;
                break;
            }
        }
        if (!onlyOneNumber && n > 1000 && n < 10000) {
            int len = 4;
            Integer[] sortArrayNum = new Integer[len];
            Integer[] reversSortArrayNum = new Integer[len];

            for (int i = 0; i < len; i++) {
                sortArrayNum[i] = Character.getNumericValue(arrayNum[i]);
                reversSortArrayNum[i] = Character.getNumericValue(arrayNum[i]);
            }

            Arrays.sort(sortArrayNum);
            Arrays.sort(reversSortArrayNum, Collections.reverseOrder());

            Integer[] buf = new Integer[len];

            for (int i = len - 1; i >= 0; i--) {
                if (reversSortArrayNum[i] >= sortArrayNum[i]) {
                    buf[i] = reversSortArrayNum[i] - sortArrayNum[i];
                } else {
                    reversSortArrayNum[i] += 10;
                    reversSortArrayNum[i - 1] -= 1;
                    buf[i] = reversSortArrayNum[i] - sortArrayNum[i];
                }
                reversSortArrayNum[i] = buf[i];
                sortArrayNum[i] = buf[i];
            }

            return 1 + kaprekar(sortArrayNum, reversSortArrayNum);
        } else return -1;

    }

    //Task_6 func+
    public static int kaprekar(Integer[] sortArrayNum, Integer[] reversSortArrayNum) {
        int len = 4;
        Integer[] Kaprekar = {6, 1, 7, 4};
        Arrays.sort(sortArrayNum);
        Arrays.sort(reversSortArrayNum, Collections.reverseOrder());

        Integer[] buf = new Integer[len];

        for (int i = len - 1; i >= 0; i--) {
            if (reversSortArrayNum[i] >= sortArrayNum[i]) {
                buf[i] = reversSortArrayNum[i] - sortArrayNum[i];
            } else {
                reversSortArrayNum[i] += 10;
                reversSortArrayNum[i - 1] -= 1;
                buf[i] = reversSortArrayNum[i] - sortArrayNum[i];
            }
            reversSortArrayNum[i] = buf[i];
            sortArrayNum[i] = buf[i];
        }
        if (!Arrays.equals(sortArrayNum, Kaprekar)) {
            return 1 + kaprekar(sortArrayNum, reversSortArrayNum);
        } else return 1;
    }

    //Task_7_1 func
    public static int rotateRight(int n, int shift) {
        char[] bit_num = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < shift; i++) {
            pushRight(bit_num);
        }
        String ans = new String(bit_num);
        return Integer.parseInt(ans, 2);
    }

    public static void pushRight(char @NotNull [] arr) {
        char lastNum = arr[arr.length - 1];
        char oldValue;
        char newValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            oldValue = arr[i];
            arr[i] = newValue;
            newValue = oldValue;
        }
        arr[0] = lastNum;
    }

    //Task_7_2 func
    public static int rotateLeft(int n, int shift) {
        char[] bit_num = Integer.toBinaryString(n).toCharArray();
        for (int i = 0; i < shift; i++) {
            pushLeft(bit_num);
        }
        String ans = new String(bit_num);
        return Integer.parseInt(ans, 2);
    }

    public static void pushLeft(char @NotNull [] arr) {
        char firstNum = arr[0];
        char oldValue;
        char newValue = arr[1];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = firstNum;
    }

    //Task_8
    public static boolean knightBoardCapture(int[] @NotNull [] chessboard) {
        boolean ans = true;
        boolean is8X8 = true;
        for (int[] row : chessboard) {
            if (row.length != 8) {
                is8X8 = false;
                break;
            }
        }
        if (chessboard.length != 8) {
            is8X8 = false;
            return is8X8;
        }

        if (is8X8) {
            final int L = chessboard.length;
            int numberOfKnights = 0;
            for (int[] ints : chessboard) {
                for (int j = 0; j < L; j++) {
                    if (ints[j] != 0) numberOfKnights++;
                }
            }

            int[][] knights = new int[numberOfKnights][];
            int index = 0;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < L; j++) {
                    if (chessboard[i][j] != 0) {
                        knights[index] = new int[]{i, j};
                        index++;
                    }
                }
            }
            final double Length = Math.pow(2, 2) + 1;

            for (int i = 0; i < numberOfKnights; i++) {
                for (int j = 0; j < numberOfKnights; j++) {
                    int a = knights[i][0] - knights[j][0];
                    int b = knights[i][1] - knights[j][1];
                    if ((Math.pow(a, 2) + Math.pow(b, 2)) == Length) {
                        ans = false;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        //Task_0
        System.out.print("Task_0: ");
        LOGGER.info();

        //Task_1
        System.out.println("Task_1: " + minutesToSeconds("12:30"));

        //Task_2
        System.out.println("Task_2: " + countDigits(123));

        //Task_3
        float[] a1 = {1, 2, 3, 4};
        float[] a2 = {2, 3};
        System.out.println("Task_3: " + isNestable(a1, a2));

        //Task_4
        System.out.println("Task_4: " + fixString("ad"));

        //Task_5
        System.out.println("Task_5: " + isPalindromeDescendant(344));

        //Task_6
        System.out.println("Task_6: " + countK(1234));

        //Task_7
        System.out.println("Task_7_1: " + rotateRight(8, 1));
        System.out.println("Task_7_2: " + rotateLeft(17, 2));

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
        System.out.println("Task_8: " + knightBoardCapture(arr));

    }
}
