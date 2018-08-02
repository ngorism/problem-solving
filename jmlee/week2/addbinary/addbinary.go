package addbinary

import (
	"strconv"
)

func addBinary(a string, b string) string {
	carry := 0
	lenLong := max(len(a), len(b))
	runSlice := make([]rune, lenLong+1)

	left := reverse(a)
	right := reverse(b)

	var i int
	for i = 0; i < lenLong; i++ {
		sum := getBinaryValue(i, left) + getBinaryValue(i, right) + carry
		if sum > 1 {
			carry = 1
			sum = sum % 2
		} else {
			carry = 0
		}

		runSlice[i] = rune(sum + '0')
	}

	if carry > 0 {
		runSlice[i] = rune(1 + '0')
		return reverse(string(runSlice))
	} else {
		return reverse(string(runSlice[:lenLong]))
	}
}

func max(left, right int) int {
	if left > right {
		return left
	} else {
		return right
	}
}

func getBinaryValue(index int, binary string) int {
	if index > len(binary)-1 {
		return 0
	} else {
		if []rune(binary)[index] == '1' {
			return 1
		} else {
			return 0
		}
	}
}

func reverse(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func convertRuneToInt(a rune) int {
	return int(a) - '0'
}

func simpleSolution(a string, b string) string {
	intA, err := strconv.ParseUint(a, 2, 64)
	if err != nil {
		return ""
	}

	intB, err := strconv.ParseUint(b, 2, 64)
	if err != nil {
		return ""
	}

	resultInt := intA + intB
	return strconv.FormatUint(resultInt, 2)
}