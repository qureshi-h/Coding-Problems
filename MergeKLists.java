import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

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
class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {

        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val-node2.val;
            }
        };

        Queue<ListNode> queue = new PriorityQueue<ListNode>(comparator);

        for (ListNode node: lists)
            if (node != null) queue.add(node);

        ListNode head = queue.poll();
        if (head != null && head.next != null) queue.add(head.next);

        ListNode currentNode = head;
        while(!queue.isEmpty()) {

            currentNode.next = queue.poll();
            currentNode = currentNode.next;
            if (currentNode.next != null) queue.add(currentNode.next);
        }

        return head;
    }
}  