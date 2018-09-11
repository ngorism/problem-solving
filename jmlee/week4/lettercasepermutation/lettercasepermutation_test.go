package lettercasepermutation

import (
	"reflect"
	"testing"
)

func TestLetterCasePermutation(t *testing.T) {
	input := "a1b2"
	expectedOutput := []string{"a1b2", "A1b2", "a1B2", "A1B2"}
	output := letterCasePermutation(input)
	if !reflect.DeepEqual(expectedOutput, output) {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	input = "3z4"
	expectedOutput = []string{"3z4", "3Z4"}
	output = letterCasePermutation(input)
	if !reflect.DeepEqual(expectedOutput, output) {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}

	input = "12345"
	expectedOutput = []string{"12345"}
	output = letterCasePermutation(input)
	if !reflect.DeepEqual(expectedOutput, output) {
		t.Errorf("Expected result is %v but the result is %v", expectedOutput, output)
	}
}
