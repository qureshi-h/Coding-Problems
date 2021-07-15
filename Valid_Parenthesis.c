/*
solution to https://leetcode.com/problems/valid-parentheses/
*/


struct LinkedList {
    char val;
    struct LinkedList* next;
};

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', 
determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.

100% / 100% 
*/
bool isValid(char * s){
    struct LinkedList* head = NULL;
    int length = strlen(s);
    for (int i = 0; i < length; i++) {
        if (!process_char(&head, s[i])) return 0;
    }
    if (head != NULL)
        return 0;
    return 1;
}

struct LinkedList* insert_at_head(struct LinkedList* head, char value) {
    struct LinkedList *new = malloc(sizeof(*new));
    new->val = value;
    if (head)
        new->next = head;
    else
        new->next = NULL;
    return new;  
}

bool process_char(struct LinkedList** head, char value) {
    if (value == '(' || value == '[' || value == '{') {
        *head = insert_at_head(*head, value);
        return 1;
    } else if ((*head != NULL) && ((value == ')' && (*head)->val == '(') ||
              (value == '}' && (*head)->val == '{') ||
              (value == ']' && (*head)->val == '['))) {
        struct LinkedList* temp = *head;
        *head = (*head)->next;
        //free(temp);
        return 1;
    }
    return 0;
}
