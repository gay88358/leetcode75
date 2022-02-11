package leetcode55;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void jump_from_one_value_array() {
        var s = new Solution();

        assertTrue(s.canJump(new int[] { 1 }));
        assertTrue(s.canJump(new int[] { 0 }));
    }

    @Test
    void jump_from_two_value_array() {
        var s = new Solution();

        assertTrue(s.canJump(new int[] { 1, 1 }));
        assertTrue(s.canJump(new int[] { 0 }));
    }

    @Test
    void jump_from_five_value_array() {
        var s = new Solution();

        assertTrue(s.canJump(new int[] { 2,3,1,1,4 }));
        assertFalse(s.canJump(new int[] { 3,2,1,0,4 }));
    }
}