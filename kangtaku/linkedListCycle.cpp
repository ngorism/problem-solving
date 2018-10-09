/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
        if (head ==  NULL) {
            return false;
        }
        
        ListNode* first = head;
        ListNode* second = head;
        
        while (first && first->next && second->next && second->next->next) {
            first = first->next;
            second = second->next->next;
            if (first == second) {
                return true;
            }
        }
        return false;
    }
};
