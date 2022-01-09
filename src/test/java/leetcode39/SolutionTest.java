package leetcode39;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void find_combination_sum() {
        var s = new Solution();

        var result = s.combinationSum(new int[] { 2, 3, 6, 7 }, 7);

        assertEquals(Arrays.asList(2, 2, 3), result.get(0));
        assertEquals(Collections.singletonList(7), result.get(1));
    }

    @Test
    void find_empty_combination_sum() {
        var s = new Solution();

        var result = s.combinationSum(new int[] { 2 }, 1);

        assertEquals(0, result.size());
    }
}