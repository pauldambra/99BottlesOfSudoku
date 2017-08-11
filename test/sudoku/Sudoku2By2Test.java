package sudoku;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class Sudoku2By2Test extends SudokuTest {

    @TestFactory
    List<DynamicTest> sudokuTests() {
        return asList(
            // Already solved
            dynamicTest("Solving an already solved puzzle makes no changes", () -> sudokuTest(
                    "1 2",  "1 2",
                    "2 1",  "2 1"))
            ,dynamicTest("Solving the other already solved puzzle makes no changes", () -> sudokuTest(
                    "2 1",  "2 1",
                    "1 2",  "1 2"))

            // One cell missing
            ,dynamicTest("Top Left Missing", () -> sudokuTest(
                    "0 2",  "1 2",
                    "2 1",  "2 1"))
            ,dynamicTest("Top Left Missing, other solution", () -> sudokuTest(
                    "0 1",  "2 1",
                    "1 2",  "1 2"))

            ,dynamicTest("Top Right Missing", () -> sudokuTest(
                    "1 0",  "1 2",
                    "2 1",  "2 1"))
            ,dynamicTest("Top Right Missing, other solution", () -> sudokuTest(
                    "2 0",  "2 1",
                    "1 2",  "1 2"))
//
            ,dynamicTest("Bottom Right Missing", () -> sudokuTest(
                    "1 2",  "1 2",
                    "2 0",  "2 1"))
            ,dynamicTest("Bottom Right Missing, other solution", () -> sudokuTest(
                    "2 1",  "2 1",
                    "1 0",  "1 2"))

            ,dynamicTest("Bottom Left Missing", () -> sudokuTest(
                    "1 2",  "1 2",
                    "0 1",  "2 1"))
            ,dynamicTest("Bottom Left Missing, other solution", () -> sudokuTest(
                    "2 1",  "2 1",
                    "0 2",  "1 2"))
//
            // Two cells missing
            ,dynamicTest("Top Row Missing", () -> sudokuTest(
                    "0 0",  "1 2",
                    "2 1",  "2 1"))
            ,dynamicTest("Top Row Missing, other solution", () -> sudokuTest(
                    "0 0",  "2 1",
                    "1 2",  "1 2"))

            ,dynamicTest("Right Column Missing", () -> sudokuTest(
                    "1 0",  "1 2",
                    "2 0",  "2 1"))
            ,dynamicTest("Right Column Missing, other solution", () -> sudokuTest(
                    "2 0",  "2 1",
                    "1 0",  "1 2"))

            ,dynamicTest("Bottom Row Missing", () -> sudokuTest(
                    "1 2",  "1 2",
                    "0 0",  "2 1"))
            ,dynamicTest("Bottom Row Missing, other solution", () -> sudokuTest(
                    "2 1",  "2 1",
                    "0 0",  "1 2"))

            ,dynamicTest("Left Column Missing", () -> sudokuTest(
                    "0 2",  "1 2",
                    "0 1",  "2 1"))
            ,dynamicTest("Left Column Missing, other solution", () -> sudokuTest(
                    "0 1",  "2 1",
                    "0 2",  "1 2"))

            // Three cells missing
            ,dynamicTest("Top Left only present", () -> sudokuTest(
                    "1 0",  "1 2",
                    "0 0",  "2 1"))
            ,dynamicTest("Top Left only present, other solution", () -> sudokuTest(
                    "2 0",  "2 1",
                    "0 0",  "1 2"))

            ,dynamicTest("Top Right only present", () -> sudokuTest(
                    "0 2",  "1 2",
                    "0 0",  "2 1"))
            ,dynamicTest("Top Right only present, other solution", () -> sudokuTest(
                    "0 1",  "2 1",
                    "0 0",  "1 2"))
//
            ,dynamicTest("Bottom Right only present", () -> sudokuTest(
                    "0 0",  "1 2",
                    "0 1",  "2 1"))
            ,dynamicTest("Bottom Right only present, other solution", () -> sudokuTest(
                    "0 0",  "2 1",
                    "0 2",  "1 2"))
//
            ,dynamicTest("Bottom Left only present", () -> sudokuTest(
                    "0 0",  "1 2",
                    "2 0",  "2 1"))
            ,dynamicTest("Bottom Left only present, other solution", () -> sudokuTest(
                    "0 0",  "2 1",
                    "1 0",  "1 2"))
                );
    }

}
