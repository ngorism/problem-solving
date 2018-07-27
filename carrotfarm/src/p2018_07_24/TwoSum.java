package p2018_07_24;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * Created on 2018. 7. 21..
 */
public class TwoSum {


	public int[] twoSum(int[] nums, int target) {

		int[] result = new int[2];
		List<Integer> idxList = new ArrayList<>();

		for (int i=0;i<nums.length;i++) {
			idxList.add(nums[i]);
		}

		for (int i=0;i<nums.length;i++) {

			int idx = idxList.indexOf(target - nums[i]);
			if ( idx !=-1 ) {
				if (i == idx) {
					idx = idxList.lastIndexOf(target - nums[i]);    // 처음은 한 번 더 기회를 주지만

					if ( idx !=-1 && i != idx) {                       // 두번째에도 자신인 경우는 제외
						result[0] = i;
						result[1] = idx;
						break;
					}
				}else {
					result[0] = i;
					result[1] = idx;
					break;
				}
			}
		}
		return result;
	}

	@Test
	public void test() {

		assertArrayEquals(twoSum(new int[] {2, 7, 11, 15}, 9), new int[] { 0, 1 });
		assertArrayEquals(twoSum(new int[] {2, 7, 11, 15}, 18), new int[] { 1, 2 });
		assertArrayEquals(twoSum(new int[] {3, 2, 4}, 6), new int[] { 1, 2 });
		assertArrayEquals(twoSum(new int[] {3, 3}, 6), new int[] { 0, 1 });
		assertArrayEquals(twoSum(new int[] {0, 4, 3, 0}, 0), new int[] { 0, 3 });
		assertArrayEquals(twoSum(new int[] {-1,-2,-3,-4,-5}, -8), new int[] { 2, 4 });
	}
}
