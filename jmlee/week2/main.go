package main

import (
	"fmt"

	"github.com/jeongmin/problem-solving/jmlee/week2/validparentheses"
)

func main() {

	testStr := "()"
	result := validparentheses.IsValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "()[]{}"
	result = validparentheses.IsValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "(]"
	result = validparentheses.IsValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "([)]"
	result = validparentheses.IsValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "{[]}"
	result = validparentheses.IsValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "{[[][{()}]]}"
	result = validparentheses.IsValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = "{{)}"
	result = validparentheses.IsValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)

	testStr = ""
	result = validparentheses.IsValid(testStr)
	fmt.Printf("%v is %v\n", testStr, result)
}
