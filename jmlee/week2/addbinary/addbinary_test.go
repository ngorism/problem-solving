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

	// Input: a = "11", b = "1"
	// Output: "100"
	inputA = "11"
	inputB = "1"
	expectedResult = "100"
	result = AddBinary(inputA, inputB)
	if strings.Compare(result, expectedResult) != 0 {
		t.Errorf("%v + %v = %v, but the expected result is %v", inputA, inputB, result, expectedResult)
	}

	// Input: a = "1010", b = "1011"
	// Output: "10101"
	inputA = "1010"
	inputB = "1011"
	expectedResult = "10101"
	result = AddBinary(inputA, inputB)
	if strings.Compare(result, expectedResult) != 0 {
		t.Errorf("%v + %v = %v, but the expected result is %v", inputA, inputB, result, expectedResult)
	}

	// Input: a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
	//        b = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
	// Output: "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
	inputA = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
	inputB = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101"
	expectedResult = "110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000"
	result = AddBinary(inputA, inputB)
	if strings.Compare(result, expectedResult) != 0 {
		t.Errorf("%v + %v = %v, but the result is expected %v", inputA, inputB, result, expectedResult)
	}

}
