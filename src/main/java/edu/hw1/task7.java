import org.jetbrains.annotations.NotNull;

public class task7 {
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
}
