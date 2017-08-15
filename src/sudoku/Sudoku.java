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

    class CellWithinPuzzle {
        private final int[][] puzzle;
        private final int row;
        private final int column;

        CellWithinPuzzle(int[][] puzzle, int row, int column) {
            this.puzzle = puzzle;
            this.row = row;
            this.column = column;
        }

        boolean isSet() {
            return puzzle[row][column] != 0;
        }

        private int[] neighbours(int[][] puzzle, int row, int column) {
            return new int[]{puzzle[1 - row][column], puzzle[row][1 - column]};
        }

        boolean neighboursAre(int value) {
            int[] neighbours = neighbours(puzzle, row, column);
            return Arrays.stream(neighbours).anyMatch(n -> n == value);
        }

        int[][] setCell(int value) {
            int[][] puzzleCopy = Arrays.stream(puzzle).map(int[]::clone).toArray(int[][]::new);
            puzzleCopy[row][column] = value;
            return puzzleCopy;
        }

        SolutionAttemptResult trySolve() {
            if (isSet()) return new SolutionAttemptResult(false, puzzle);

            if (neighboursAre(2)) return new SolutionAttemptResult(true, setCell(1));

            if (neighboursAre(1)) return new SolutionAttemptResult(true, setCell(2));

            return new SolutionAttemptResult(false, puzzle);
        }
    }

    class SolutionAttemptResult {
        private final boolean didChangeCell;
        private final int[][] puzzle;

        SolutionAttemptResult(boolean didChangeCell, int[][] puzzle) {
            this.didChangeCell = didChangeCell;
            this.puzzle = puzzle;
        }
    }

    private int[][] solve(int[][] puzzle) {

        int squareMax = 1;

        for (int row = 0; row <= squareMax; row++) {
            for (int column = 0; column <= squareMax; column++) {
                SolutionAttemptResult cellResult = new CellWithinPuzzle(puzzle, row, column).trySolve();
                if (cellResult.didChangeCell) {
                    return solve(cellResult.puzzle);
                }
            }
        }

        return puzzle;
    }

}
