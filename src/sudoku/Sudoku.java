package sudoku;

public class Sudoku {

    public int[][] solve(int[][] puzzle) {
        for(int row = 0; row < 2 ; row ++) {
            for(int col = 0 ; col < 2 ; col ++) {
                if (puzzle[row][col] == 0) {
                    for (int i = 1; i <= 2; i++) {
                        if (puzzle[row][otherIndex(col)] == i || puzzle[otherIndex(row)][col] == i) {
                            puzzle[row][col] = otherValue(i);
                            return solve(puzzle);
                        }
                    }
                }
            }
        }
        return puzzle;
    }

    private int otherIndex(int index) {
        return 1-index;
    }

    private int otherValue(int i) {
        return 3 - i;
    }

}
