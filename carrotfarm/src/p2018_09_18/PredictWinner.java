package p2018_09_18;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class PredictWinner {

	// wrong answer
	public boolean PredictTheWinner(int[] nums) {
		if (nums.length <= 2) {
			return true;
		}

		int head = 0;
		int tail = nums.length - 1;

		int p1=0,p2=0;

		boolean p1Turn = true;

		while ( tail - head >= 3) {     // 4개 이상

			if ((nums[head] + nums[tail-1]) >= (nums[head+1] + nums[tail])) {
				if (p1Turn) {
					p1 += nums[head];
				}else {
					p2 += nums[head];
				}
				head++;
			}else {
				if (p1Turn) {
					p1 += nums[tail];
				}else {
					p2 += nums[tail];
				}
				tail--;
			}
			p1Turn = !p1Turn;
		}

		if (tail - head == 2) {         // 3개
			if (p1Turn) {
				p1 = p1 + Math.max(nums[head], nums[tail]) + Math.min(nums[head+1], Math.min(nums[head], nums[tail]));
				p2 = p2 + Math.max(nums[head+1], Math.min(nums[head], nums[tail]));
			}else {
				p2 = p2 + Math.max(nums[head], nums[tail]) + Math.min(nums[head+1], Math.min(nums[head], nums[tail]));
				p1 = p1 + Math.max(nums[head+1], Math.min(nums[head], nums[tail]));
			}
		}

		return p1>=p2;
	}

	@Test
	public void test() {


		assertEquals(PredictTheWinner(new int[] {
			3606449,6,5,9,452429,7,9580316,9857582,8514433,9,6,6614512,753594,5474165,4,2697293,8,7,1
		}), false);
//		assertEquals(PredictTheWinner(new int[] {1, 1, 1}), true);
//		assertEquals(PredictTheWinner(new int[] {1, 5, 2}), false);
//		assertEquals(PredictTheWinner(new int[] {1, 5, 233, 7}), true);
	}

}
