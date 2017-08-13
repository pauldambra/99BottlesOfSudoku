package sudoku;

import javafx.scene.control.Cell;

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
            return new int[] { puzzle[1-row][column], puzzle[row][1-column] };
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
    }

    public int[][] solve(int[][] puzzle) {

        CellWithinPuzzle bottomRight = new CellWithinPuzzle(puzzle, 1, 1);
        if (!bottomRight.isSet()) {
            if (bottomRight.neighboursAre(2)) {
                puzzle = bottomRight.setCell(1);
                return solve(puzzle);
            }

            if (bottomRight.neighboursAre(1)){
                puzzle = bottomRight.setCell(2);
                return solve(puzzle);
            }
        }

        CellWithinPuzzle bottomLeft = new CellWithinPuzzle(puzzle, 1, 0);
        if (!bottomLeft.isSet()) {
            if (bottomLeft.neighboursAre(2)) {
                puzzle = bottomLeft.setCell(1);
                return solve(puzzle);
            }
            if (bottomLeft.neighboursAre(1)) {
                puzzle = bottomLeft.setCell(2);
                return solve(puzzle);
            }
        }

        CellWithinPuzzle topRight = new CellWithinPuzzle(puzzle, 0, 1);
        if (!topRight.isSet()) {
            if (topRight.neighboursAre(2)) {
                puzzle = topRight.setCell(1);
                return solve(puzzle);
            }
            if (topRight.neighboursAre(1)){
                puzzle = topRight.setCell(2);
                return solve(puzzle);
            }
        }

        CellWithinPuzzle topLeft = new CellWithinPuzzle(puzzle, 0, 0);
        if (!topLeft.isSet()) {
            if (topLeft.neighboursAre(2)) {
                puzzle = topLeft.setCell(1);
                return solve(puzzle);
            }
            if (topLeft.neighboursAre(1)) {
                puzzle = topLeft.setCell(2);
                return solve(puzzle);
            }
        }

        return puzzle;
    }

}
