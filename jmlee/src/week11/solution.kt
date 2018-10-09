package week11

import week10.middleOfTheLinkedList.ListNode


/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
fun hasCycle(head: ListNode): Boolean {
    if (head.next == null) return false

    var rabbit: ListNode? = head.next
    var tortoise: ListNode? = head
    var index = 0
    while (rabbit != null) {
        if (rabbit == tortoise) return true

        rabbit = rabbit.next
        if (index % 2 == 1) tortoise = tortoise?.next
        index++
    }
    return false
}