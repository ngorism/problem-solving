package p2018_07_24;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// discuss 참조
public class NumberofIslands {


	public int numIslands(char[][] grid) {


		int cnt = 0;
		for (int i=0;i<grid.length;i++) {
			for (int j=0;j<grid[0].length;j++) {

				if (grid[i][j] == '1') {
					cnt++;
					eraseLand(grid, i, j);
				}
			}
		}
//		System.out.println(cnt);
		return cnt;
	}

	private void eraseLand(char[][] grid, int i, int j) {

		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
			return;
		}
		if (grid[i][j] == '1') {
			grid[i][j] = '0';
			eraseLand(grid, i-1, j);
			eraseLand(grid, i+1, j);
			eraseLand(grid, i, j+1);
			eraseLand(grid, i, j-1);
		}
	}


	@Test
	public void test() {

		assertEquals(numIslands(new char[][] {
				"11110".toCharArray(),
				"11010".toCharArray(),
				"11000".toCharArray(),
				"00000".toCharArray()
		}), 1);

		assertEquals(numIslands(new char[][] {
			"11000".toCharArray(),
			"11000".toCharArray(),
			"00100".toCharArray(),
			"00011".toCharArray()
		}), 3);
	}
}
