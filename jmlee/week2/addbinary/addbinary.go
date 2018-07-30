package addbinary

import (
	"strconv"
)

func AddBinary(a string, b string) string {
	/*
		adding := 0
		lenLong := max(len(a), len(b))
		var buffer bytes.Buffer

		if i, err := strconv.Btoi64("1001", 2); err != nil {


		for i := lenLong - 1; i >= 0; i-- {
			sum := getBinaryValue(i, a) + getBinaryValue(i, b) + adding
			if sum > 1 {
				sum = sum % 2
				adding = 1
			} else {
				adding = 0
			}

			buffer.WriteRune()

		}

		return "a"
	*/
	//intA, err := strconv.Btoi64(a, 2)
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
