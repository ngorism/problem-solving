package themaze

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

const none = -1
const up = 0
const down = 1
const left = 2
const right = 3

func hasPath(maze [][]int, start []int, destination []int) bool {
	if maze[destination[0]][destination[1]] != 0 {
		return false
	}
	visited := make([][]int, len(maze))
	copy(visited, maze)
	for i := range maze {
		visited[i] = make([]int, len(maze[i]))
		copy(visited[i], maze[i])
	}

	return findPath(maze, start, destination, visited)
}

func findPath(maze [][]int, position []int, destination []int, visited [][]int) bool {
	if isSamePosition(position, destination) {
		return true
	}

	var dest []int
	dest = goTo(up, position, maze, visited)
	if !isSamePosition(position, dest) { // up
		if findPath(maze, dest, destination, visited) {
			return true
		}
	}

	dest = goTo(down, position, maze, visited)
	if !isSamePosition(position, dest) { // down
		if findPath(maze, dest, destination, visited) {
			return true
		}
	}

	dest = goTo(left, position, maze, visited)
	if !isSamePosition(position, dest) {
		if findPath(maze, dest, destination, visited) {
			return true
		}
	}

	dest = goTo(right, position, maze, visited)
	if !isSamePosition(position, dest) {
		if findPath(maze, dest, destination, visited) {
			return true
		}
	}

	return false
}

func goTo(direction int, position []int, maze [][]int, visited [][]int) []int {
	dest := make([]int, 2)
	dest[0] = position[0]
	dest[1] = position[1]

	row := position[0]
	column := position[1]
	index := 0

	switch direction {
	case up:
		for index = row; index > 0; index-- {
			if maze[index-1][column] != 0 {
				break
			}
		}
		dest[0] = index
	case down:
		for index = row; index < len(maze)-1; index++ {
			if maze[index+1][column] != 0 {
				break
			}
		}
		dest[0] = index
	case left:
		for index = column; index > 0; index-- {
			if maze[row][index-1] != 0 {
				break
			}
		}
		dest[1] = index
	case right:
		for index = column; index < len(maze[row])-1; index++ {
			if maze[row][index+1] != 0 {
				break
			}
		}
		dest[1] = index
	}

	if dest[0] == 4 && dest[1] == 4 {
		dest[0] = 4
	}

	if visited[dest[0]][dest[1]] == 1 {
		dest[0] = position[0]
		dest[1] = position[1]
	} else {
		visited[dest[0]][dest[1]] = 1
	}

	return dest
}

func isSamePosition(src, dst []int) bool {
	return len(src) == 2 && len(dst) == 2 && src[0] == dst[0] && src[1] == dst[1]
}

func canVisit(row, column int, maze [][]int, visited map[int]int) bool {
	if row >= 0 && row < len(maze) && column >= 0 && column < len(maze[row]) {
		return visited[row] != column
	} else {
		return false
	}
}
