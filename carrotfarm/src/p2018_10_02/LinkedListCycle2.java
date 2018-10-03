package p2018_10_02;

public class LinkedListCycle2 {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode detectCycle(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode rabbit = head;
		ListNode turtle = head;

		while(rabbit.next != null && rabbit.next.next != null) {

			turtle = turtle.next;
			rabbit = rabbit.next.next;
			if (turtle == rabbit) {

				while(head != rabbit) {
					head = head.next;
					rabbit = rabbit.next;
				}
				return head;
			}
		}
		return null;
	}
}
