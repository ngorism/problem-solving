package searchinsertposition

import "testing"

/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
*/

func TestSearchInsert(t *testing.T) {
	input := []int{1, 3, 5, 6}
	inputIndex := 5
	expectedOutput := 2
	output := searchInsert(input, inputIndex)
	if expectedOutput != output {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	//input = []int{1, 3, 5, 6}
	inputIndex = 2
	expectedOutput = 1
	output = searchInsert(input, inputIndex)
	if expectedOutput != output {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	//input = []int{1, 3, 5, 6}
	inputIndex = 7
	expectedOutput = 4
	output = searchInsert(input, inputIndex)
	if expectedOutput != output {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	inputIndex = 0
	expectedOutput = 0
	output = searchInsert(input, inputIndex)
	if expectedOutput != output {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	input = []int{1}
	inputIndex = 0
	expectedOutput = 0
	output = searchInsert(input, inputIndex)
	if expectedOutput != output {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	input = []int{1, 3, 5}
	inputIndex = 1
	expectedOutput = 0
	output = searchInsert(input, inputIndex)
	if expectedOutput != output {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}
}
