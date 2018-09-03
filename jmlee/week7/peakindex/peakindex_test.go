package peakindex

import "testing"

func TestPeakIndexInMountainArray(t *testing.T) {
	input := []int{0, 1, 0}
	expectedOutput := 1
	output := peakIndexInMountainArray(input)
	if expectedOutput != output {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	input = []int{0, 2, 1, 0}
	expectedOutput = 1
	output = peakIndexInMountainArray(input)
	if expectedOutput != output {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	input = []int{3, 4, 5, 1}
	expectedOutput = 2
	output = peakIndexInMountainArray(input)
	if expectedOutput != output {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}
}
