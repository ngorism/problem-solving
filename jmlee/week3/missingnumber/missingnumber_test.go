package missingnumber

import "testing"

/*
Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
*/
func TestMissingNumbers(t *testing.T) {
	input := []int{3, 0, 1}
	expectedOutput := 2
	output := missingNumber(input)
	if output != expectedOutput {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	input = []int{9, 6, 4, 2, 3, 5, 7, 0, 1}
	expectedOutput = 8
	output = missingNumber(input)
	if output != expectedOutput {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}
}
