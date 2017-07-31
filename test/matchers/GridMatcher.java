package matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public class GridMatcher extends TypeSafeMatcher<int[][]> {

    private final int[][] expectedSolution;

    public GridMatcher(int[][] expectedSolution) {
        this.expectedSolution = expectedSolution;
    }

    @Override
    protected boolean matchesSafely(int[][] grid) {
        if (grid == null && expectedSolution == null)
            return true;

        if (grid == null || expectedSolution == null)
            return false;

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++)
                if (grid[i][j] != expectedSolution[i][j])
                    return false;

        return true;
    }

    @Override
    public void describeTo(Description description) {
        describeGrid(expectedSolution, description);
    }

    @Override
    protected void describeMismatchSafely(int[][] grid, Description mismatchDescription) {
        describeGrid(grid, mismatchDescription);
    }

    private void describeGrid(int[][] grid, Description description) {

        description.appendText("\n\t");
        for (int i = 0; i < grid.length; i++) {
//                description.appendText("[");
            for (int j = 0; j < grid.length; j++) {
                description.appendValue(grid[i][j]);
                if (j < grid.length - 1)
                    description.appendText(/*"," +*/ " ");
            }
//                description.appendText("]");
            if (i < grid.length - 1)
                description.appendText("\n\t");
        }
    }


    public static GridMatcher gridMatches(int[][] solution) {
        return new GridMatcher(solution);
    }

}
