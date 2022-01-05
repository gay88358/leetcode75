package leetcode21;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void merge_two_null_nodes() {
        var s = new Solution();

        assertNull(s.mergeTwoLists(null, null));
    }

    @Test
    void merge_two_sorted_nodes() {
        var s = new Solution();

        var result = s.mergeTwoLists(ListNode.createNodes(1, 2, 3), ListNode.createNodes(2, 3, 4));

        assertEquals(ListNode.createNodes(1, 2, 2, 3, 3, 4), result);
    }
}