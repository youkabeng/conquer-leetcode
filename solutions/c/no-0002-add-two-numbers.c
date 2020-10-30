// @desc-start
// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
// You may assume the two numbers do not contain any leading zero, except the number 0 itself.
//  
// Example 1:
// 
// 
// Input: l1 = [2,4,3], l2 = [5,6,4]
// Output: [7,0,8]
// Explanation: 342 + 465 = 807.
// 
// Example 2:
// 
// Input: l1 = [0], l2 = [0]
// Output: [0]
// 
// Example 3:
// 
// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: [8,9,9,9,0,0,0,1]
// 
//  
// Constraints:
// 
// The number of nodes in each linked list is in the range [1, 100].
// 0 <= Node.val <= 9
// It is guaranteed that the list represents a number that does not have leading zeros.
// 
// 
// @desc-end

struct ListNode {
	int val;
	struct ListNode *next;
};


// @code-start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

#include <stdlib.h>
#include <stddef.h>
typedef struct ListNode node;

node *addTwoNumbers(struct ListNode *l1, struct ListNode *l2)
{
    node dummy = {0};
    node *tmp = &dummy;
    node *t1 = l1;
    node *t2 = l2;

    int carry = 0;
    while (t1 || t2)
    {
        int v1 = t1 ? t1->val : 0;
        int v2 = t2 ? t2->val : 0;
        int v = (v1 + v2 + carry) % 10;
        carry = (v1 + v2 + carry) / 10;
        node *n = (node *)malloc(sizeof(node));
        n->val = v;
        n->next = NULL;
        tmp->next = n;
        tmp = n;
        if (t1)
            t1 = t1->next;
        if (t2)
            t2 = t2->next;
    }
    if (carry == 1)
    {
        node *n = (node *)malloc(sizeof(node));
        n->val = carry;
        n->next = NULL;
        tmp->next = n;
    }
    return dummy.next;
}
// @code-end
