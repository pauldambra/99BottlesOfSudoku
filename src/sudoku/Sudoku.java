package sudoku;

public class Sudoku {

    public int[][] solve(int[][] puzzle) {

        if (puzzle[1][1] == 0) {
            if (puzzle[1][0] == 2 || puzzle[0][1] == 2) {
                puzzle[1][1] = 1;
                return solve(puzzle);
            }
            if (puzzle[1][0] == 1 || puzzle[0][1] == 1){
                puzzle[1][1] = 2;
                return solve(puzzle);
            }
        }

        if (puzzle[1][0] == 0) {
            if (puzzle[1][1] == 2 || puzzle[0][0] == 2) {
                puzzle[1][0] = 1;
                return solve(puzzle);
            }
            if (puzzle[1][1] == 1 || puzzle[0][0] == 1) {
                puzzle[1][0] = 2;
                return solve(puzzle);
            }
        }

        if (puzzle[0][1] == 0) {
            if (puzzle[0][0] == 2 || puzzle[1][1] == 2) {
                puzzle[0][1] = 1;
                return solve(puzzle);
            }
            if (puzzle[0][0] == 1 || puzzle[1][1] == 1){
                puzzle[0][1] = 2;
                return solve(puzzle);
            }
        }

        if (puzzle[0][0] == 0) {
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
