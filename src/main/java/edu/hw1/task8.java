import org.jetbrains.annotations.NotNull;

public class task8 {
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
}
