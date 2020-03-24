/*
Solution to problem from 
https://leetcode.com/problems/add-two-numbers/
*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

/* Returns sum of two nodes */
int addTwoDigits(struct ListNode* l1, struct ListNode* l2, int *carry) {
    
    int sum = *carry;
    if (l1) sum += l1->val;
    if (l2) sum += l2-> val;
    
    if (sum >= 10) { 
        *carry = 1;
        return sum - 10;
    }
    *carry = 0;
    return sum;
}

/* Returns sum of two reverse linked lists in O(n) time complexity
96.05% faster than submitted solutions with 100% lesser space consumption */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    
    struct ListNode *l3 = malloc(sizeof(*l3));
    struct ListNode *curr = l3;
    int carry = 0;
    
    curr->val = addTwoDigits(l1, l2, &carry);
    while (1) {
        if (l1) l1 = l1->next;
        if (l2) l2 = l2->next;
        
        if (!(l1 || l2) && !carry) break;
        curr = (curr->next = malloc(sizeof(*curr)));
        curr->val = addTwoDigits(l1, l2, &carry);
    }    
    curr->next = NULL;
    return l3;
}
