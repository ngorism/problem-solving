package p2018_08_21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

//  Time Limit Exceeded
public class HouseRobber {

	public int rob(int[] nums) {

		return Math.max(robbing(nums, 0, 0), robbing(nums, 1, 0));
	}

	private int robbing(int[] nums, int idx, int sum) {

		if (idx >= nums.length) {
			return sum;
		}
		sum += nums[idx];
		return Math.max(robbing(nums, idx+2, sum), robbing(nums, idx+3, sum));
	}

	@Test
	public void test() {

		assertEquals(rob(new int[] {1,2,3,1}), 4);
		assertEquals(rob(new int[] {2,7,9,3,1}), 12);
	}
}
