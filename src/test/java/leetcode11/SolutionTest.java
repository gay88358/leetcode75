package leetcode11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    public void max_water_one() {
        var s = new Solution();
        int result = s.maxArea(new int[] { 1,1 });
        assertEquals(1, result);
    }

    @Test
    public void max_water_size() {
        var s = new Solution();
        int result = s.maxArea(new int[] { 1,8,6,2,5,4,8,3,7 });
        assertEquals(49, result);
    }
}