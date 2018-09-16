package p2018_08_14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//If you have figured out the O(n) solution,
// try coding another solution using the divide and conquer approach, which is more subtle.

public class MaximumSubarray {

	public int maxSubArray(int[] nums) {

		int totMax = nums[0];
		int tmpMax = nums[0];

		for (int i=1; i< nums.length; i++) {

			int val = nums[i];
			if (val > tmpMax || val > 0) {
				tmpMax = Math.max(val, tmpMax+val);
			}else {
				tmpMax = tmpMax + val;
			}
			if (tmpMax > totMax) {
				totMax = tmpMax;
			}
		}
		return  totMax;
	}

	@Test
	public void test() {
//		4,-1,2,1
		assertEquals(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}), 6);
	}
}
