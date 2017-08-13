package sudoku;

import java.util.Arrays;

// if a cell is not set
// then check if its neighbours are 2
// * if it is set the cell to 1 and recurse
// * if it is not
// * * then check if its neighbours are 1
// * * if they are then set the cell to 2 and recurse
// the values repeat... the concepts repeat...
// the concepts are missing from the code entirely
public class Sudoku {

    private boolean isSet(int[][] puzzle, int row, int column) {  return puzzle[row][column] != 0;  }

    private int[] neighbours(int[][] puzzle, int row, int column) {
        return new int[] { puzzle[1-row][column], puzzle[row][1-column] };
    }

    private boolean neighboursAre(int value, int[][] puzzle, int row, int column) {
        int[] neighbours = neighbours(puzzle, row, column);
        return Arrays.stream(neighbours).anyMatch(n -> n == value);
    }

    public int[][] solve(int[][] puzzle) {

        if (!isSet(puzzle, 1, 1)) {
            if (neighboursAre(2, puzzle, 1, 1)) {
                puzzle[1][1] = 1;
                return solve(puzzle);
            }

            if (neighboursAre(1, puzzle, 1, 1)){
                puzzle[1][1] = 2;
                return solve(puzzle);
            }
        }

        if (!isSet(puzzle, 1, 0)) {
            if (puzzle[1][1] == 2 || puzzle[0][0] == 2) {
                puzzle[1][0] = 1;
                return solve(puzzle);
            }
            if (puzzle[1][1] == 1 || puzzle[0][0] == 1) {
                puzzle[1][0] = 2;
                return solve(puzzle);
            }
        }

        if (!isSet(puzzle, 0, 1)) {
            if (puzzle[0][0] == 2 || puzzle[1][1] == 2) {
                puzzle[0][1] = 1;
                return solve(puzzle);
            }
            if (puzzle[0][0] == 1 || puzzle[1][1] == 1){
                puzzle[0][1] = 2;
                return solve(puzzle);
            }
        }

        if (!isSet(puzzle, 0, 0)) {
            if (puzzle[0][1] == 2 || puzzle[1][0] == 2) {
                puzzle[0][0] = 1;
                return solve(puzzle);
            }
            if (puzzle[0][1] == 1 || puzzle[1][0] == 1) {
                puzzle[0][0] = 2;
                return solve(puzzle);
            }
        }

        return puzzle;
    }

}
