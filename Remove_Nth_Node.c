/* 
solution to https://leetcode.com/problems/remove-nth-node-from-end-of-list/
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


/*
removes the nth node from the end of the linked list
100% / 80 %
*/

struct ListNode* removeNthFromEnd(struct ListNode* head, int n){
    
    ++n;
    struct ListNode **nodes = (struct ListNode**)malloc(sizeof(*nodes) * n);
    int curr_pos = 0;
    struct ListNode *curr_node;
    for (curr_node = head; curr_node; curr_node = curr_node->next) {
        nodes[curr_pos % n] = curr_node;
        curr_pos++;
    }
    
    if (curr_pos == n - 1) {
        return head->next;
    }
    
    curr_pos %= n;
    curr_node = nodes[curr_pos]->next;
    nodes[curr_pos]->next = curr_node->next;
    
    return head;
}

