/**
 * solution to https://leetcode.com/problems/merge-k-sorted-lists/
 */

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

    /*
    Merges k sorted linked lists into a single sorted linked list
    80% / 60%
     */
    public ListNode mergeKLists(ListNode[] lists) {

        Comparator<ListNode> comparator = (node1, node2) -> node1.val-node2.val;
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