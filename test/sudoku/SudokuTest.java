package sudoku;

import java.util.List;
import java.util.function.IntPredicate;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static matchers.GridMatcher.gridMatches;
import static org.hamcrest.MatcherAssert.assertThat;

public class SudokuTest {
    private final Sudoku sudoku = new Sudoku();

    protected void sudokuTest(String... rows) {

        assert(rows.length % 2 == 0);

        int [][] puzzle   = buildGrid(choose(this::even, rows));
        int [][] solution = buildGrid(choose(this::odd,  rows));

        assertThat(sudoku.solve(puzzle), gridMatches(solution));
    }

    private List<String> choose(IntPredicate oddOrEvenFn, String[] allRows) {
        return range(0, allRows.length).
                filter(oddOrEvenFn).
                mapToObj(i -> allRows[i]).
                collect(toList());
    }

    private boolean odd(int i) {
        return i % 2 == 1;
    }

    private boolean even(int i) {
        return i % 2 == 0;
    }

    private int[][] buildGrid(List<String> rows) {
        return rows.stream().
                map(row -> stream(row.split(" ")).
                                        mapToInt(Integer::parseInt).
                                        toArray()).
                collect(toList()).toArray(new int[rows.size()][rows.size()]);
    }

}
