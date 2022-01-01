package leetcode19;


public class ListNode {
    // declarative design (factory method) to hide internal structure of linked-list to reduce coupling
    // between test and production code.
    public static ListNode createNodes(Integer ...numbers) {
        return createNodesByIndex(0, numbers);
    }

    private static ListNode createNodesByIndex(int index, Integer ...numbers) {
        if (index >= numbers.length) {
            return null;
        }
        return new ListNode(numbers[index], createNodesByIndex(index + 1, numbers));
    }

    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public int size() {
        ListNode current = this;
        int result = 0;
        while (current != null) {
            current = current.next;
            result++;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ListNode)) {
            return false;
        }
        ListNode listNode = (ListNode) o;

        if (listNode.next == null && this.next == null && listNode.val == this.val) {
            return true;
        }

        if (listNode.val != this.val) {
            return false;
        }
        return next.equals(listNode.next);
    }

    public void remove(ListNode listNode) {
        ListNode dummy = new ListNode(-1, this);
        ListNode prev = dummy;
        ListNode current = dummy.next;

        while (current != null) {
            if (current.val == listNode.val) {
                break;
            }
            prev = current;
            current = current.next;
        }

        ListNode nodeToRemove = current;
        prev.next = nodeToRemove.next;
        nodeToRemove.next = null;
    }
}
