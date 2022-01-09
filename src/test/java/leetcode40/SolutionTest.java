package leetcode40;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void find_combination_sum() {
        var s = new Solution();

        var result = s.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8);

        assertEquals(result.get(0), Arrays.asList(1, 1, 6));
        assertEquals(result.get(1), Arrays.asList(1, 2, 5));
        assertEquals(result.get(2), Arrays.asList(1, 7));
        assertEquals(result.get(3), Arrays.asList(2, 6));
    }
}