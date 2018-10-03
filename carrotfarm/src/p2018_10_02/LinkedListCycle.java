package p2018_10_02;

public class LinkedListCycle {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {

		boolean result = false;
		if (head == null) {
			return false;
		}

		ListNode rabbit = head;
		ListNode turtle = head;

		while(rabbit.next != null && rabbit.next.next != null) {

			turtle = turtle.next;
			rabbit = rabbit.next.next;
			if (turtle == rabbit) {
				result = true;
				break;
			}
		}
		return result;
	}

}
