package main

import "fmt"

func minPathSum2(grid [][]int) int {
	rowLen := len(grid)
	colLen := len(grid[0])
	dp := make([][]int, rowLen)
	for i := range dp {
		dp[i] = make([]int, colLen)
	}

	dp[0][0] = grid[0][0]
	for i := 1; i < colLen; i++ {
		dp[0][i] = grid[0][i] + dp[0][i-1]
	}

	for i := 1; i < rowLen; i++ {
		dp[i][0] = grid[i][0] + dp[i-1][0]
	}

	for i := 1; i < rowLen; i++ {
		for j := 1; j < colLen; j++ {
			left := grid[i][j] + dp[i][j-1]
			up := grid[i][j] + dp[i-1][j]
			if left > up {
				dp[i][j] = up
			} else {
				dp[i][j] = left
			}
		}
	}

	return dp[rowLen-1][colLen-1]
}

func minPathSum(grid [][]int) int {
	rowLen := len(grid)
	colLen := len(grid[0])

	for i := 1; i < colLen; i++ {
		grid[0][i] += grid[0][i-1]
	}

	for i := 1; i < rowLen; i++ {
		grid[i][0] += grid[i-1][0]
	}

	for i := 1; i < rowLen; i++ {
		for j := 1; j < colLen; j++ {
			left := grid[i][j-1] + grid[i][j]
			up := grid[i-1][j] + grid[i][j]
			if left > up {
				grid[i][j] = up
			} else {
				grid[i][j] = left
			}
		}
	}

	return grid[rowLen-1][colLen-1]
}

func main() {
	grid := [][]int{
		{1, 3, 1},
		{1, 5, 1},
		{4, 2, 1},
	}
	fmt.Println("minPathSum(grid):", minPathSum(grid))

	grid = [][]int{
		{1, 2, 5},
		{3, 2, 1},
	}
	fmt.Println("minPathSum(grid):", minPathSum(grid))
}
