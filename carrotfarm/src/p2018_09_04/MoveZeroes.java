package p2018_09_04;

import org.junit.Test;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {

		int tmp = 0;
		int zeroCnt = 0;
		for (int i=0; i < nums.length; i++) {

			if (nums[i]==0) {
				zeroCnt++;
				continue;
			}else {
				tmp = nums[i];
				nums[i-zeroCnt] = tmp;
			}
		}
		for (int i=0;i<zeroCnt;i++) {
			nums[nums.length - 1 - i] = 0;
		}

//		for (int i=0; i < nums.length; i++) {
//			System.out.println(nums[i]);
//		}
	}

	@Test
	public void test() {

		moveZeroes(new int[] {0,1,0,3,12});
	}
}
