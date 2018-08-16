package maximumsubarray

import (
	"testing"
)

func TestMaximumSubarray(t *testing.T) {
	input := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	expectedOutput := 6 //[]int{4, -1, 2, 1}
	output := maxSubArray(input)
	if expectedOutput != output {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}
}
