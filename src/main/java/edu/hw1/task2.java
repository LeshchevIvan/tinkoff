public class task2 {
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
}
