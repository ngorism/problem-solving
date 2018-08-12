package p2018_08_07;

import org.junit.Test;

public class Matrix01 {

//	Time Limit Exceeded
	int minDistance = 0;

	public int[][] updateMatrix(int[][] matrix) {

		for (int i=0;i<matrix.length;i++)
			for (int j=0;j<matrix[0].length;j++) {
				if (matrix[i][j]!=0) {
					minDistance = Integer.MAX_VALUE;

					int[][] visit = new int[matrix.length][matrix[0].length];
					setDistance(matrix, visit, i, j, i, j, 0, -1);
				}
			}

		for (int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix[0].length;j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println("");
		}


		return matrix;
	}
	private void setDistance(int[][] matrix, int[][] visit, int startX, int startY, int i, int j, int distance, int arrow) {
		if (i<0 || i >= matrix.length || j<0 || j >= matrix[0].length || distance >= minDistance) {
			return;
		}

		if (0 < visit[i][j] && visit[i][j] < distance) {
			return;
		}

		if (matrix[i][j] == 0) {
			minDistance = distance;
			matrix[startX][startY] = minDistance;
		}else {
			visit[i][j] = distance+1;

			if (arrow != 1)
				setDistance(matrix, visit, startX, startY, i + 1, j, distance + 1, 0);
			if (arrow != 0)
				setDistance(matrix, visit, startX, startY, i - 1, j, distance + 1, 1);
			if (arrow != 3)
				setDistance(matrix, visit, startX, startY, i, j+ 1, distance + 1, 2);
			if (arrow != 2)
				setDistance(matrix, visit, startX, startY, i, j -1, distance + 1, 3);

		}
	}


	@Test
	public void test() {

//		assertArrayEquals(updateMatrix(new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}), new int[][] {{0, 0, 0}, {0, 1, 0}, {1, 2, 1}});

		updateMatrix(new int[][] {
			{0, 0, 1, 0, 1, 1, 1, 0, 1, 1},
			{1, 1, 1, 1, 0, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 1, 0, 0, 0, 1, 1},
			{1, 0, 1, 0, 1, 1, 1, 0, 1, 1},
			{0, 0, 1, 1, 1, 0, 1, 1, 1, 1},
			{1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
			{1, 1, 1, 1, 0, 1, 0, 1, 0, 1},
			{0, 1, 0, 0, 0, 1, 0, 0, 1, 1},
			{1, 1, 1, 0, 1, 1, 0, 1, 0, 1},
			{1, 0, 1, 1, 1, 0, 1, 1, 1, 0}
		});

//		0 0 1 0 1 2 1 0 1 2
//		1 1 2 1 0 1 1 1 2 3
//		2 1 2 1 1 0 0 0 1 2
//		1 0 1 0 1 1 1 0 1 2
//		0 0 1 1 1 0 1 1 2 3
//		1 0 1 2 1 1 1 2 1 2
//		1 1 1 1 0 1 0 1 0 1
//		0 1 0 0 0 1 0 0 1 2
//		1 1 1 0 1 1 0 1 0 1
//		1 0 1 1 1 0 1 2 1 0

//		assertArrayEquals(updateMatrix(new int[][] {{0, 1, 0, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}}), new int[][] {{0, 1, 0, 0}, {1, 2, 1, 1}, {2, 3, 2, 2}});

	}
}
