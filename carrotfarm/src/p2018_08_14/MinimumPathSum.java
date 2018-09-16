package p2018_08_14;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

// Time Limit Exceeded
public class MinimumPathSum {

	int distance = Integer.MAX_VALUE;

	public int minPathSum(int[][] grid) {

		search(grid, 0, 0, 0);

		return distance;
	}

	private void search(int[][] grid, int m, int n, int sum) {

		if (m == grid.length-1 && n == grid[0].length -1) {     // bottom right
			if (sum + grid[m][n] < distance) {
				distance = sum + grid[m][n];
			}
			return;
		}

		sum = sum + grid[m][n];
		if (sum >= distance) {
			return;
		}

		if (m < grid.length - 1) {
			search(grid, m + 1, n, sum);
		}
		if (n < grid[0].length - 1) {
			search(grid, m, n + 1, sum);
		}
	}



	@Test
	public void test() {

		assertEquals(minPathSum(new int[][] {
			{1, 3, 1},
			{1, 5, 1},
			{4, 2, 1}}), 7);

		assertEquals(minPathSum(new int[][] {
			{1, 2},
			{5, 6},
			{1, 1}}), 7);
	}
}
