package p2018_08_28;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {

		int l = 0;
		int r = nums.length;

		int mid = 0;
		while(l < r) {

			mid = (l+r) / 2;
			if (nums[mid] == target) {
				return mid;
			}else if (nums[mid] > target) {
				r = mid;
			}else {
				l = mid;
			}
			if (r==0) {
				return 0;
			}
			if (l==nums.length-1) {
				return nums.length;
			}
			if (nums[l] < target && r-l == 1) {
				return r;
			}
		}
		return 0;
	}

	@Test
	public void test() {

//		assertEquals(searchInsert(new int[] {1,3,5,6}, 5), 2);
//		assertEquals(searchInsert(new int[] {1,3,5,6}, 2), 1);
//		assertEquals(searchInsert(new int[] {1,3,5,6}, 7), 4);
//		assertEquals(searchInsert(new int[] {1,3,5,6}, 0), 0);
		assertEquals(searchInsert(new int[] {1,3}, 1), 0);
	}
}
