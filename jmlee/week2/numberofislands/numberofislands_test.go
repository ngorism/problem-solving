package numberofislands

import "testing"

func TestAddBinary(t *testing.T) {
	// Example 1:
	// Input:
	// 11110
	// 11010
	// 11000
	// 00000
	// Output: 1
	grid := [][]byte{{'1', '1', '1', '1', '0'},
		{'1', '1', '0', '1', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '0', '0', '0'}}

	expectedResult := 1
	size := numIslands(grid)
	if size != expectedResult {
		t.Errorf("Expected result is %v but the result is %v", expectedResult, size)
	}

	// Example 2:
	// Input:
	// 11000
	// 11000
	// 00100
	// 00011
	// Output: 3
	grid = [][]byte{{'1', '1', '0', '0', '0'},
		{'1', '1', '0', '0', '0'},
		{'0', '0', '1', '0', '0'},
		{'0', '0', '0', '1', '1'}}

	expectedResult = 3
	size = numIslands(grid)
	if size != expectedResult {
		t.Errorf("Expected result is %v but the result is %v", expectedResult, size)
	}

	// Example 3:
	// Input:
	// 111
	// 010
	// 111
	// Output: 1
	grid = [][]byte{{'1', '1', '1'},
		{'0', '1', '0'},
		{'1', '1', '1'}}
	expectedResult = 1
	size = numIslands(grid)
	if size != expectedResult {
		t.Errorf("Expected result is %v but the result is %v", expectedResult, size)
	}

}
