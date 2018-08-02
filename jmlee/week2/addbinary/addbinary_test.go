package addbinary

import (
	"strings"
	"testing"
)

func TestAddBinary(t *testing.T) {
	var inputA string
	var inputB string
	var expectedResult string
	var result string

	inputA = "0"
	inputB = "0"
	expectedResult = "0"
	result = addBinary(inputA, inputB)
	if strings.Compare(result, expectedResult) != 0 {
		t.Errorf("%v + %v = %v, but the expected result is %v", inputA, inputB, result, expectedResult)
	}

	// Input: a = "11", b = "1"
	// Output: "100"
	inputA = "11"
	inputB = "1"
	expectedResult = "100"
	result = addBinary(inputA, inputB)
	if strings.Compare(result, expectedResult) != 0 {
		t.Errorf("%v + %v = %v, but the expected result is %v", inputA, inputB, result, expectedResult)
	}

	// Input: a = "1010", b = "1011"
	// Output: "10101"
	inputA = "1010"
	inputB = "1011"
	expectedResult = "10101"
	result = addBinary(inputA, inputB)
	if strings.Compare(result, expectedResult) != 0 {
		t.Errorf("%v + %v = %v, but the expected result is %v", inputA, inputB, result, expectedResult)
	}

}
