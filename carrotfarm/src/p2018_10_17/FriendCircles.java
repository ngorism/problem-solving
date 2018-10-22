package p2018_10_17;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class FriendCircles {

	public int findCircleNum(int[][] M) {

		int cnt = 0;
		for (int i=0;i<M.length;i++) {
			for (int j=0;j<M[0].length;j++) {

				if (M[i][j] == 1) {
					cnt++;
					eraseCircle(M, i, j);
				}
			}
		}
		return cnt;
	}
	private void eraseCircle(int[][] M, int i, int j) {

		for (int idx=j;idx<M.length;idx++) {

			if (M[i][idx] == 1) {
				M[i][idx] = 0;
				eraseCircle(M, idx, 0);
			}
		}
	}

	@Test
	public void test() {

		assertEquals(findCircleNum(new int[][] {
			{1,1,0},
			{1,1,0},
			{0,0,1},
		}), 2);

		assertEquals(findCircleNum(new int[][] {
			{1,1,0},
			{1,1,1},
			{0,1,1},
		}), 1);

		assertEquals(findCircleNum(new int[][] {
			{1,0,0,1},
			{0,1,1,0},
			{0,1,1,1},
			{1,0,1,1}
		}), 1);
	}
}
