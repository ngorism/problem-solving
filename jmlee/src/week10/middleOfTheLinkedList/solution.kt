package week10.middleOfTheLinkedList

class ListNode(var `val`: Int = 0) {
    var next: ListNode? = null
}

/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int = 0) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun middleNode(head: ListNode?): ListNode? {
        head ?: return null

        var cur: ListNode? = head
        var mid: ListNode? = null
        var index = 1
        var midIndex = 0

        while (cur != null) {
            val tmp = index / 2 + 1
            if (tmp != midIndex) {
                midIndex = tmp
                mid = if (mid == null) head else mid.next
            }

            index++
            cur = cur.next
        }

        return mid
    }
}