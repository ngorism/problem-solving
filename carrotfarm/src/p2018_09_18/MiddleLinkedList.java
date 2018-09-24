package p2018_09_18;

public class MiddleLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode middleNode(ListNode head) {

		int cnt = 0;

		ListNode node = head;
		while(node != null) {
			node = node.next;
			cnt++;
		}
		ListNode result = head;
		for (int i=0;i<cnt/2;i++) {
			result = result.next;
		}

		return result;
	}


}
