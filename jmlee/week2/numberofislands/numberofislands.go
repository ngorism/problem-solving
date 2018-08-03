package numberofislands

import "fmt"

/*

Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input:
11110
11010
11000
00000
Output: 1
*/
func numIslands(grid [][]byte) int {
	var numLands int
	for row := range grid {
		for column := range grid[row] {
			if grid[row][column] == '1' {
				landSize := sinkTheLand(row, column, 0, grid)
				if landSize > 0 {
					numLands++
				}
			}
		}
	}

	fmt.Println(numLands)
	return numLands
}

func sinkTheLand(row int, column int, landSize int, grid [][]byte) int {
	if grid[row][column] == '0' {
		return landSize
	} else {
		landSize++
		grid[row][column] = '0'
	}

	up := row - 1
	down := row + 1
	left := column - 1
	right := column + 1

	if up >= 0 {
		landSize = sinkTheLand(up, column, landSize, grid)
	}

	if down < len(grid) {
		landSize = sinkTheLand(down, column, landSize, grid)
	}

	if left >= 0 {
		landSize = sinkTheLand(row, left, landSize, grid)
	}

	if right < len(grid[row]) {
		landSize = sinkTheLand(row, right, landSize, grid)
	}

	return landSize
}
