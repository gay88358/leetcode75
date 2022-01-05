package leetcode21;
// 技術: two pointers
// 實作細節: 利用sorted的特性來移動two pointers
//          當list1為空時，直接連接剩餘的list2 (因為已經排序過)
//          當list2為空時，直接連接剩餘的list1 (因為已經排序過)
public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = list1;
        ListNode second = list2;
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (first != null || second != null) {
            if (first == null) {
                current.next = second;
                break;
            }
            if (second == null) {
                current.next = first;
                break;
            }
            if (first.val > second.val) {
                current.next = second;
                current = current.next;
                second = second.next;
            } else {
                current.next = first;
                current = current.next;
                first = first.next;
            }
        }
        return dummy.next;
    }
}
