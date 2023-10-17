import org.jetbrains.annotations.NotNull;

public class task3 {
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
}
