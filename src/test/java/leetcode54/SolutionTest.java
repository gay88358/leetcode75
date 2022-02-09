package leetcode54;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void spiral_order_of_single_row() {
        var s = new Solution();
        assertEquals(
                s.spiralOrder(
                        new int[][] {{ 1 }}),
                Collections.singletonList(1)
        );

        assertEquals(
                s.spiralOrder(
                        new int[][] {{ 1, 2, 3 }}),
                Arrays.asList(1, 2, 3)
        );
        assertEquals(
                s.spiralOrder(
                        new int[][] {{ 2, 4, 5 }}),
                Arrays.asList(2, 4, 5)
        );
    }

    @Test
    void spiral_order_of_two_row() {
        var s = new Solution();
        assertEquals(
                s.spiralOrder(
                        new int[][] {{ 1, 2, 3 }, { 4, 5, 6 }}),
                Arrays.asList(1, 2, 3, 6, 5, 4)
        );
    }

    @Test
    void spiral_order_of_one_column() {
        var s = new Solution();
        assertEquals(
                s.spiralOrder(
                        new int[][] {{ 1 }, { 4 }, { 5 }}),
                Arrays.asList(1, 4, 5)
        );
    }

    @Test
    void spiral_order_of_two_columns() {
        var s = new Solution();
        assertEquals(
                s.spiralOrder(
                        new int[][] {{ 1, 2 }, { 4, 3 }, { 5, 6 }}),
                Arrays.asList(1, 2, 3, 6, 5, 4)
        );
    }

    @Test
    void spiral_order_of_three_by_three_matrix() {
        var s = new Solution();

        int[][] matrix = new int[][] {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        var result = s.spiralOrder(matrix);
        assertEquals(result, Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5));
    }

    @Test
    void spiral_order_four_by_four_matrix() {
        var s = new Solution();

        int[][] matrix = new int[][] {
                { 1, 2, 3, 4 },
                { 4, 5, 6, 5 },
                { 7, 8, 9, 6 }
        };

        var result = s.spiralOrder(matrix);
        assertEquals(result, Arrays.asList(1, 2, 3, 4, 5, 6, 9, 8, 7, 4, 5, 6));
    }
}