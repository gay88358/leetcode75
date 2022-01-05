package leetcode23;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    void merge_empty_list() {
        var s = new Solution();

        var result = s.mergeKLists(new ListNode[] {});

        assertNull(result);
    }

    @Test
    void merge_multiple_sorted_list() {
        var s = new Solution();

        var result = s.mergeKLists(
                new ListNode[] {
                        ListNode.createNodes(1, 2, 3),
                        ListNode.createNodes(2, 3, 4),
                        ListNode.createNodes(5, 6, 7),
                });

        assertEquals(
                ListNode.createNodes(1, 2, 2, 3, 3, 4, 5, 6, 7),
                result
        );
    }

    @Test
    void merge_two_sorted_list() {
        var s = new Solution();

        var result = s.mergeKLists(
                new ListNode[] {
                        ListNode.createNodes(1, 2, 3),
                        ListNode.createNodes(2, 3, 4)
                });

        assertEquals(
                ListNode.createNodes(1, 2, 2, 3, 3, 4),
                result
        );
    }
}