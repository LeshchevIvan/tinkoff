import org.jetbrains.annotations.NotNull;

public class task1 {
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
}
