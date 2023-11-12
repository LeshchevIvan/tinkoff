package edu.hw1;
import org.jetbrains.annotations.NotNull;

public class Task1 {
    public static int minutesToSeconds(@NotNull String time) {
        String[] time_array;
        char[] correct_symbols = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        time_array = time.split(":");
        int minutes = 0;
        int seconds = 0;

        boolean IsCorrect = false;
        if (time_array.length == 2) {
            minutes=countMinutes(time_array,correct_symbols,IsCorrect);
            if(minutes!=-1){
                IsCorrect=true;
                seconds=countSeconds(time_array,correct_symbols,IsCorrect);
                if (seconds==-1){
                    IsCorrect=false;
                }
            }

        }
        int ans = minutes * 60 + seconds;
        if (IsCorrect) return ans;
        else return -1;
    }
    private static int countMinutes(String[] time_array,char[] correct_symbols, boolean IsCorrect){
        int minutes=0;
        int mul=1;
        char[] temp = time_array[0].toCharArray();
        for (int i = temp.length - 1; i >= 0; i--) {
            for (var correct_symbol : correct_symbols) {
                if (temp[i] == correct_symbol) {
                    minutes += Character.getNumericValue(temp[i]) * mul;
                    mul *= 10;
                    IsCorrect = true;
                    break;
                } else {
                    IsCorrect = false;
                }
            }
            if (!IsCorrect) {
                return -1;
            }
        }
        return minutes;
    }

    private static int countSeconds(String[] time_array,char[] correct_symbols, boolean IsCorrect){
        char[] temp = time_array[1].toCharArray();
        int mul = 1;
        int seconds=0;
        if (temp.length == 2 && IsCorrect && temp[0] < '6') {
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
        } else return -1;
        return seconds;
    }
}
