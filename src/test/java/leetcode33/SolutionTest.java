package leetcode33;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void search_value_in_left_sorted_portion_boundary() {
        var s = new Solution();

        assertEquals(1, s.search(new int[] { 3, 1 }, 1));
    }

    @Test
    void search_absent_value_in_sorted_array() {
        var s = new Solution();

        assertEquals(-1, s.search(new int[] { 4,5,6,7,0,1,2 }, 3));
        assertEquals(-1, s.search(new int[] { 1 }, 0));
    }

    @Test
    void search_value_in_rotated_sorted_array() {
        var s = new Solution();

        assertEquals(4, s.search(new int[] { 4,5,6,7,0,1,2 }, 0));
    }
}