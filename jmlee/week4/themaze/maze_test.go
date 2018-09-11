package themaze

import "testing"

/*
There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.

The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.

Example 1

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (4, 4)

Output: true
Explanation: One possible way is : left -> down -> left -> down -> right -> down -> right.

Example 2

Input 1: a maze represented by a 2D array

0 0 1 0 0
0 0 0 0 0
0 0 0 1 0
1 1 0 1 1
0 0 0 0 0

Input 2: start coordinate (rowStart, colStart) = (0, 4)
Input 3: destination coordinate (rowDest, colDest) = (3, 2)

Output: false
Explanation: There is no way for the ball to stop at the destination.

Note:
There is only one ball and one destination in the maze.
Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
The given maze does not contain border (like the red rectangle in the example pictures), but you could assume the border of the maze are all walls.
The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
*/
func TestMaze(t *testing.T) {

	maze := [][]int{
		{0, 0, 1, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 1, 0},
		{1, 1, 0, 1, 1},
		{0, 0, 0, 0, 0}}

	start := []int{0, 4}
	destination := []int{4, 4}
	expectedOutput := true
	output := hasPath(maze, start, destination)
	if output != expectedOutput {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	start = []int{0, 4}
	destination = []int{3, 2}
	expectedOutput = false
	output = hasPath(maze, start, destination)
	if output != expectedOutput {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}
}

func TestGoTo(t *testing.T) {
	maze := [][]int{
		{0, 0, 1, 0, 0},
		{0, 0, 0, 0, 0},
		{0, 0, 0, 1, 0},
		{1, 1, 0, 1, 1},
		{0, 0, 0, 0, 0}}

	visited := make([][]int, len(maze))
	copy(visited, maze)
	for i := range maze {
		visited[i] = make([]int, len(maze[i]))
		copy(visited[i], maze[i])
	}

	startAt := []int{0, 4}
	dest := goTo(up, startAt, maze, visited)
	expectedDest := []int{0, 4}
	if !isSamePosition(dest, expectedDest) {
		t.Errorf("Expected result is %v but the result is %v", expectedDest, dest)
	}

	startAt = []int{0, 4}
	dest = goTo(left, startAt, maze, visited)
	expectedDest = []int{0, 3}
	if !isSamePosition(dest, expectedDest) {
		t.Errorf("Expected result is %v but the result is %v", expectedDest, dest)
	}

	startAt = []int{0, 4}
	dest = goTo(right, startAt, maze, visited)
	expectedDest = []int{0, 4}
	if !isSamePosition(dest, expectedDest) {
		t.Errorf("Expected result is %v but the result is %v", expectedDest, dest)
	}

	startAt = []int{0, 4}
	dest = goTo(down, startAt, maze, visited)
	expectedDest = []int{2, 4}
	if !isSamePosition(dest, expectedDest) {
		t.Errorf("Expected result is %v but the result is %v", expectedDest, dest)
	}

}
