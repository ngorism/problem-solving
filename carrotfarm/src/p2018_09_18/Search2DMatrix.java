package p2018_09_18;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {

		if (matrix ==null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int left = 0;
		int right = matrix.length * matrix[0].length;

		int preVal = Integer.MIN_VALUE;

		while(left < right) {

			int mid = (left + right ) / 2;
			int val = matrix[mid/matrix[0].length][mid%matrix[0].length];
			if (val == target) {
				return true;
			}
			if (val < target) {
				left = mid;
			}else {
				right = mid;
			}
			if (val == preVal) {
				return false;
			}
			preVal = val;
		}

		return false;
	}

	@Test
	public void test() {

		assertEquals(searchMatrix(new int[][] {
			{}
		},1), false);

		assertEquals(searchMatrix(new int[][] {
			{1, 3}
		},1), true);

		assertEquals(searchMatrix(new int[][] {
			{1}
		},1), true);

		assertEquals(searchMatrix(new int[][] {
			{1, 3, 5, 7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		},3), true);

		assertEquals(searchMatrix(new int[][] {
			{1, 3, 5, 7},
			{10, 11, 16, 20},
			{23, 30, 34, 50}
		},13), false);
	}

}
