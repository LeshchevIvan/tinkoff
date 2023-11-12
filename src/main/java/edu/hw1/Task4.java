package edu.hw1;
import org.jetbrains.annotations.NotNull;

public class Task4 {
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
        } else {
            for (int i = 0; i < len - 2; i += 2) {
                buf = ans[i];
                ans[i] = ans[i + 1];
                ans[i + 1] = buf;
            }
        }
        return String.valueOf(ans);
    }
}
