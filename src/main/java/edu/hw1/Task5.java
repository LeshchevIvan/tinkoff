package edu.hw1;



public class Task5 {
    public static boolean isPalindromeDescendant(Integer number) {
        boolean isPalindrome = false;
        char[] arr_num;
        number = Math.abs(number);

        while (!isPalindrome && number > 10) {

            arr_num = (number.toString()).toCharArray();

            //CHECK PALINDROME
            isPalindrome = checkPalindrome(arr_num);
            //FIND Descendant
            if (!isPalindrome) {
                number = findDescendant(arr_num, number);
            }
        }
        return isPalindrome;
    }

    private static boolean checkPalindrome(char[] arr_num) {
        int len = arr_num.length;
        boolean isPalindrome = false;
        for (int i = 0; i < len / 2; i++) {
            if (arr_num[i] == arr_num[len - 1 - i]) {
                isPalindrome = true;
            }
        }
        return isPalindrome;
    }

    private static Integer findDescendant(char[] arr_num, Integer number) {
        int len = arr_num.length;
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
        return number;
    }
}
