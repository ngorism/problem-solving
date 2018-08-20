package p2018_08_14;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JumpGame {


	public boolean canJump(int[] nums) {


		int lastIdx = nums.length - 1;

		int currReachIdx = 0;
		for (int i=0; i < nums.length; i++) {

			if (i + nums[i] >= lastIdx ) {      // 0 + 4 >= 4
				return true;
			}
			if (i + nums[i] > currReachIdx ) {
				currReachIdx = i + nums[i];
			}
			if (i >= currReachIdx) {
				break;
			}
		}

		return false;
	}

	@Test
	public void test() {

//		assertEquals(canJump(new int[] {2, 3, 1, 1, 4}), true);
		assertEquals(canJump(new int[] {3, 2, 1, 0, 4}), false);

//		assertEquals(canJump(new int[] {3,0,8,2,0,0,1}), true);
	}
}
