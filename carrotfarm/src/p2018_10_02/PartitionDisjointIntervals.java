package p2018_10_02;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;


public class PartitionDisjointIntervals {

//	Given an array A, partition it into two (contiguous) subarrays left and right so that:
//
//	Every element in left is less than or equal to every element in right.
//	left and right are non-empty.
//	left has the smallest possible size.
//	Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.

	public int partitionDisjoint(int[] A) {

		int head = 0;
		int tail = A.length - 1;

		int maxHead = A[head];
		int minTail = A[tail];

		while( maxHead <= minTail && head < tail - 1) {

			if (maxHead <= A[tail-1]) {
				tail--;
				minTail =  Math.min(minTail, A[tail]);
				continue;

			}else {

				while(head < tail - 1) {
					head++;
					maxHead = Math.max(maxHead, A[head]);
				}


				for (int i=head; i < A.length-1;i++) {

					if (maxHead < A[i + 1]) {
						break;
					}
					if (maxHead > A[i + 1] ) {
						head = i+1;
					}
				}
			}
		}

		return ++head;
	}

	@Test
	public void test() {

		assertEquals(partitionDisjoint(new int[] {5,5,5,5,5}), 1);
		assertEquals(partitionDisjoint(new int[] {5,5,0,5,5}), 3);
		assertEquals(partitionDisjoint(new int[] {5,0,3,5,5}), 3);

		assertEquals(partitionDisjoint(new int[] {5,0,3,8,6}), 3);
		assertEquals(partitionDisjoint(new int[] {1,1,1,0,6,12}), 4);

		assertEquals(partitionDisjoint(new int[] {32,57,24,19,0,24,49,67,87,87}), 7);
		assertEquals(partitionDisjoint(new int[] {30,57,9,79,49,67,11,4,42,43,7,21,78,70,46,91,94,89,95,82}), 15);


		assertEquals(partitionDisjoint(new int[] {3,1,8,4,9,7,12,0,0,12,6,12,6,19,24,90,87,54,92,60,31,59,75,90,20,38,52,51,74,70,86,20,27,91,55,47,54,86,15,16,74,32,68,27,19,54,13,22,34,74,76,50,74,97,87,42,58,95,17,93,39,33,22,87,96,90,71,22,48,46,37,18,17,65,54,82,54,29,27,68,53,89,23,12,90,98,42,87,91,23,72,35,14,58,62,79,30,67,44,48}), 13);

	}

}
