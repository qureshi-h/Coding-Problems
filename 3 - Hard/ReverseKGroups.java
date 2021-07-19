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

class ReverseKGroups {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode[] kNodes = new ListNode[k];
        ListNode reversed = new ListNode();
        ListNode reversedHead = reversed;
        int i;

        while (true) {
            for (i = 0; i < k; i++) {
                if (head != null) kNodes[i] = head;
                else break;
                head = head.next;
            }
            if (i != k) break;
            reversed.next = reverse(kNodes);
            for (int j = 0; j < k; j++) reversed = reversed.next;
        }

        return reversedHead.next;
    }

    private ListNode reverse(ListNode[] nodes) {

        int j = nodes.length - 1;
        int temp_val;

        for (int i = 0; i < j; i++) {
            temp_val = nodes[i].val;
            nodes[i].val = nodes[j].val;
            nodes[j].val = temp_val;
            j--;
        }
        return nodes[0];
    }
}