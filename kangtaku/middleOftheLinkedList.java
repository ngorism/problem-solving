/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode first = head;
        int cnt = 0;
        while (first != null) {
            first = first.next;
            cnt++;
        }
        ListNode ans = head;
        int cnt2 = 0;
        cnt /= 2;
        while (cnt != cnt2) {
            ans = ans.next;
            cnt2++;
        }
        return ans;
    }
}
