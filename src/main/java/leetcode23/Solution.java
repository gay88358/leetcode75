package leetcode23;
// 技術: 利用mergeTwoList來實作，透過binary merge的方式來降低時間複雜度。
// 實作細節: 使用interval來調整步伐、當interval小於list數量停止、list數量減去interval來避免index out of range

public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        int interval = 1;
        int size = lists.length;
        while (interval < size) {
            // size - interval prevent index out of boundary
            // because we use i + interval to merge two list we need to ensure i + interval < size
            // so we have formula as i < size - interval
            // i += (interval * 2) is used to merge list by interval, so we could reduce redundany computation
            for (int i = 0; i < size - interval; i += (interval * 2)) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return (size > 0) ? lists[0] : null;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode first = list1;
        ListNode second = list2;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
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