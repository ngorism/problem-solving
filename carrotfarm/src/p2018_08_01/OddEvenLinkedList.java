package p2018_08_01;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class OddEvenLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public ListNode oddEvenList(ListNode head) {

		int cnt = 0;
		List<ListNode> oddList = new ArrayList<>();
		List<ListNode> evenList = new ArrayList<>();

		while (head != null) {

			if (cnt++ % 2 == 0) {
				oddList.add(head);
			} else {
				evenList.add(head);
			}
			head = head.next;
		}
		oddList.addAll(evenList);
		ListNode result = createNode(oddList, 0);
//		printNode(result);

		return result;
	}

	private ListNode createNode(List<ListNode> list, int idx){

		if(idx < list.size()){

			ListNode node = list.get(idx);
			node.next = createNode(list, idx+1);
			return node;
		}
		return null;
	}

	@Test
	public void test() {


		int[] input = {1,2,3,4,5};
		ListNode node = createListNode(input,1);
//		printNode(node);

		node = oddEvenList(node);
		printNode(node);
	}

	private ListNode createListNode(int[] input, int index){

		if(index <= input.length){

			int value = input[index-1];
			ListNode list = new ListNode(value);
			list.next = createListNode(input, index+1);
			return list;
		}
		return null;
	}

	private void printNode(ListNode node) {
		ListNode tmp = node;
		while(tmp!=null) {
			System.out.println(tmp.val);
			tmp = tmp.next;
		}
	}
}
