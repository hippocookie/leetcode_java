public class N2_AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        boolean isCarry = false;
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val;
            if (isCarry) {
                value++;
            }
            isCarry = value / 10 != 0;
            ListNode node = new ListNode(value % 10);
            head.next = node;
            head = node;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l1 != null) {
            head.next = l1;
        }
        if (l2 != null) {
            head.next = l2;
        }
        while (isCarry) {
            if (head.next != null) {
                head.next.val++;
            } else {
                head.next = new ListNode(1);
            }
            isCarry = head.next.val / 10 != 0;
            head.next.val %= 10;
            head = head.next;
        }
        return dummy.next;
    }
}
