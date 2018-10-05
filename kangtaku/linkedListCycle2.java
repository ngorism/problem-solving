/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        ListNode p3 = null;
        while (p2 != null && p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p3 = head;
                break;
            }
        }
        if (p3 == null) return null;
        while (p2 != p3) {
            p2 = p2.next;
            p3 = p3.next;
        }
        return p3;
    }
}
