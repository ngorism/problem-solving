package p2018_08_01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {


	public int missingNumber(int[] nums) {

		int result = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		Set<Integer> numSet = new HashSet<>();
		for (int i=0;i<nums.length;i++) {
			if (nums[i] < min) min = nums[i];
			if (nums[i] > max) max = nums[i];
			numSet.add(nums[i]);
		}

		for (int i=Math.min(min, 0);i<=max+1;i++) {
			if (!numSet.contains(i)) {
				return i;
			}
		}
		return result;
	}


	@Test
	public void test() {
		assertEquals(missingNumber(new int[] {1}), 0);
		assertEquals(missingNumber(new int[] {0}), 1);
		assertEquals(missingNumber(new int[] {0,1}), 2);
		assertEquals(missingNumber(new int[] {3,0,1}), 2);
		assertEquals(missingNumber(new int[] {9,6,4,2,3,5,7,0,1}), 8);
	}
}
