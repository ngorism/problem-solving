package p2018_08_07;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TheMaze {


	public boolean hasPath(int[][] maze, int[] start, int[] destination) {

		int sum = 0;
		sum += search(maze, start, destination, new int[]{1, 0});
		sum += search(maze, start, destination, new int[]{-1, 0});
		sum += search(maze, start, destination, new int[]{0, 1});
		sum += search(maze, start, destination, new int[]{0, -1});

		return sum > 0;
	}

	public int search(int[][] maze, int[] start, int[] destination, int[] arrow) {

		int next[] = new int[2];
		next[0] = start[0] + arrow[0];        // next position
		next[1] = start[1] + arrow[1];

		if (start[0] < 0 || start[0] >= maze.length || start[1] < 0 || start[1] >= maze[0].length ||
			maze[start[0]][start[1]] == 1) {
			return 0;
		}

		if (next[0] < 0 || next[0] >= maze.length || next[1] < 0 || next[1] >= maze[0].length
			|| maze[next[0]][next[1]]==1) {

			if (start[0] == destination[0] && start[1] == destination[1]) {
				return 1;
			}else if (maze[start[0]][start[1]] == -1) {   // already visit(-1)
				return 0;
			}else {
				maze[start[0]][start[1]] = -1;	// visit flag

				int[][] arrows = new int[][]{{1, 0},{-1, 0},{0, 1},{0, -1}};
				int sum = 0;
				for (int i=0;i<arrows.length;i++) {

					int[] position = new int[2];
					position[0] = start[0] + arrows[i][0];
					position[1] = start[1] + arrows[i][1];
					sum += search(maze, position, destination, arrows[i]);
				}
				return sum;
			}
		}
		return search(maze, next, destination, arrow);
	}

	@Test
	public void test() {

		assertEquals(hasPath(new int[][]{
			{0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0},
			{1, 1, 0, 1, 1},
			{0, 0, 0, 0, 0},
		}, new int[]{0,4}, new int[]{4,4}), true);

		assertEquals(hasPath(new int[][]{
			{0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 1, 0},
			{1, 1, 0, 1, 1},
			{0, 0, 0, 0, 0},
		}, new int[]{0,4}, new int[]{3,2}), false);
	}
}
