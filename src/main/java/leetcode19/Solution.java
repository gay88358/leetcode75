package leetcode19;

// 技術: two pointer
// 實作細節: 透過n來定位初始two pointer位置，
//          在確保two pointer間隔n元素的同時不斷循環直到right pointer越界。
//          當right pointer越界時往後數n個元素即是需要被刪除的節點。
//          透過dummy node可以解決刪除第一個節點問題 (如果沒有dummy node刪除第一個節點時會造成special case，程式碼實作不美觀)

public class Solution {
    // n should less than the size of linked-list head
    // precondition 0 <= n <= size(head)
    // define error out of exist

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n > head.size()) {
            throw new IllegalArgumentException("Given n is large than size of head node");
        }
        ListNode dummy = new ListNode(-1, head);

        ListNode left = dummy;
        ListNode right = head;
        // shift right pointer
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.remove(left.next);
        return dummy.next;
    }


}