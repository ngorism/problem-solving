package lettercasepermutation

import (
	"math"
	"unicode"
)

/*
Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.

Examples:
Input: S = "a1b2"
Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

Input: S = "3z4"
Output: ["3z4", "3Z4"]

Input: S = "12345"
Output: ["12345"]
Note:

S will be a string with length at most 12.
S will consist only of letters or digits.
*/

func letterCasePermutation(S string) []string {
	letterCount := 0
	for _, rune := range S {
		if unicode.IsLetter(rune) {
			letterCount++
		}
	}

	ret := make([]string, 1, int(math.Pow(2, float64(letterCount))))
	ret[0] = S
	ret = makePossibleString(S, ret, 0)
	return ret
}

func makePossibleString(inputString string, strings []string, index int) []string {
	if index >= len(inputString) {
		return strings
	}

	targetRune := []rune(inputString)[index]
	if unicode.IsLetter(targetRune) {
		newStrings := make([]string, len(strings))
		for i, str := range strings {
			newRuneString := []rune(str)
			if unicode.IsLower(newRuneString[index]) {
				newRuneString[index] = unicode.ToUpper(newRuneString[index])
			} else {
				newRuneString[index] = unicode.ToLower(newRuneString[index])
			}
			newStrings[i] = string(newRuneString)
		}

		for _, str := range newStrings {
			strings = append(strings, str)
		}
	}

	return makePossibleString(inputString, strings, index+1)
}
