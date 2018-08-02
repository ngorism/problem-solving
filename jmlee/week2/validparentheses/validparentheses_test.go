package validparentheses

import (
	"fmt"
	"testing"
)

/*
Input: s = "anagram", t = "nagaram"
Output: true

Input: s = "rat", t = "car"
Output: false
*/
func TestIsValid(t *testing.T) {
	testStr := "()"
	result := isValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "()[]{}"
	result = isValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "(]"
	result = isValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "([)]"
	result = isValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "{[]}"
	result = isValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "{[[][{()}]]}"
	result = isValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "{{)}"
	result = isValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = ""
	result = isValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)
}
