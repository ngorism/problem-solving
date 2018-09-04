package p2018_09_04;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MaxAreaofIsland {

	int tmpSum = 0;

	public int maxAreaOfIsland(int[][] grid) {

		int max = 0;

		for (int i=0;i<grid.length;i++) {
			for (int j=0;j<grid[0].length;j++) {

				if (grid[i][j] == 1) {

					tmpSum = 0;
					searchAreaSize(grid, i, j);
					if (tmpSum > max) {
						max = tmpSum;
					}
				}
			}
		}
		return max;
	}
	private void searchAreaSize(int[][] grid, int row, int col) {

		if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
			return;
		}
		tmpSum++;
		grid[row][col] = 0;

		searchAreaSize(grid, row-1, col);
		searchAreaSize(grid, row+1, col);
		searchAreaSize(grid, row, col+1);
		searchAreaSize(grid, row, col-1);
	}

	@Test
	public void test() {

		assertEquals(maxAreaOfIsland(new int[][]{
			{0,0,1,0,0,0,0,1,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,1,1,0,1,0,0,0,0,0,0,0,0},
			{0,1,0,0,1,1,0,0,1,0,1,0,0},
			{0,1,0,0,1,1,0,0,1,1,1,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0},
			{0,0,0,0,0,0,0,1,1,0,0,0,0}
		}), 6);
	}
}
