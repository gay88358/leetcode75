package leetcode15;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    // iterative
    // recursive

    @Test
    void three_sum_duplicate_within_first_value() {
        var s = new Solution();

        var result = s.threeSum(new int[] { -3, -3, 1, 1, 2, 2 });
        assertEquals(result.size(), 1);
        assertTrue(result.contains(Arrays.asList(-3, 1, 2)));
    }

    @Test
    void three_sum_duplicate_within_two_pointer_range() {
        var s = new Solution();

        var result = s.threeSum(new int[] { -3, 1, 1, 2, 2 });
        assertEquals(result.size(), 1);
        assertTrue(result.contains(Arrays.asList(-3, 1, 2)));
    }

    @Test
    void three_sum() {
        var s = new Solution();

        var result = s.threeSum(new int[] { -1, 0, 1, 2, -1, -4 });
        result
                .forEach(System.out::println);
        assertTrue(result.contains(Arrays.asList(-1, -1, 2)));
        assertTrue(result.contains(Arrays.asList(-1, 0, 1)));
    }

    @Test
    void three_sum_without_result() {
        var s = new Solution();

        var result = s.threeSum(new int[] { });

        assertTrue(result.isEmpty());
    }
}