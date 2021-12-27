package leetcode1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void two_sum() {
        var s = new Solution();

        int[] result = s.twoSum(new int[] { 2,7,11,15 }, 9);
        assertEquals(result.length, 2);
        assertContains(result, 0);
        assertContains(result, 1);

        result = s.twoSum(new int[] { 3,2,4 }, 6);
        assertEquals(result.length, 2);
        assertContains(result, 1);
        assertContains(result, 2);
    }

    private void assertContains(int[] nums, int value) {
        for (int num : nums) {
            if (num == value) {
                return;
            }
        }
        fail();
    }
}