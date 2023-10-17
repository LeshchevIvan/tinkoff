import java.util.Arrays;

public class task5 {
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
}
