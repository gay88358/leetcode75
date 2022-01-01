package leetcode19;

import org.junit.jupiter.api.Test;

import static leetcode19.ListNode.createNodes;
import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void remove_first_node_from_single_length_list() {
        ListNode listNode = createNodes(1);

        var s = new Solution();
        var result = s.removeNthFromEnd(listNode, 1);

        assertNull(result);
    }

    @Test
    void remove_first_node_from_list() {
        ListNode listNode = createNodes(1, 2, 3);

        var s = new Solution();
        var result = s.removeNthFromEnd(listNode, 3);

        assertEquals(createNodes(2, 3), result);
    }

    @Test
    void remove_last_node_from_list() {
        ListNode listNode = createNodes(1, 2, 3);

        var s = new Solution();
        var result = s.removeNthFromEnd(listNode, 1);

        assertEquals(createNodes(1, 2), result);
    }

    @Test
    void remove_middle_node_from_list() {
        ListNode listNode = createNodes(1, 2, 3);

        var s = new Solution();
        var result = s.removeNthFromEnd(listNode, 2);

        assertEquals(createNodes(1, 3), result);
    }

    @Test
    void remove_out_of_range_node_is_invalid() {
        ListNode listNode = createNodes(1, 2, 3);

        var s = new Solution();

        assertThrows(IllegalArgumentException.class, () -> s.removeNthFromEnd(listNode, 100));
    }

}