/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode mergedList = new ListNode(-1);
        ListNode head = mergedList;

        while (l1 != null && l2 != null) {

            mergedList = (mergedList.next = (l1.val > l2.val) ? l2 : l1);
            if (l1.val > l2.val) l2 = mergedList.next;
            else l1 = mergedList.next;
        }

        if (l1 == null) mergedList.next = l2;
        else mergedList.next = l1;

        return head.next;
    }
}