import java.util.Arrays;
import java.util.Collections;

public class task6 {
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
}
