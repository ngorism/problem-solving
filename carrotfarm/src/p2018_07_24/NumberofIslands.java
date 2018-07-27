package p2018_07_24;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created on 2018. 7. 21..
 */
public class NumberofIslands {


	public int numIslands(char[][] grid) {



		return 0;
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
