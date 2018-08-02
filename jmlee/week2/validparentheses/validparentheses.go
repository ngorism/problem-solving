package validparentheses

import (
	"errors"
)

type Stack struct {
	index int
	data  []rune
}

func (this *Stack) Init(initialCapacity int) {
	this.data = make([]rune, initialCapacity)
	this.index = -1
}

func (this *Stack) Peek() (rune, error) {
	if this.index == -1 {
		return 'a', errors.New("empty stack")
	}

	return this.data[this.index], nil
}

func (this *Stack) Pop() (rune, error) {
	rune := this.data[this.index]
	this.index--
	return rune, nil
}

func (this *Stack) Push(char rune) {
	this.index++
	this.data[this.index] = char
}

func (this *Stack) Size() int {
	return this.index + 1
}

// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
// An input string is valid if:
//    Open brackets must be closed by the same type of brackets.
//    Open brackets must be closed in the correct order.

// IsValid validate whether the string s is consisted of the valid Parentheses or not.
func isValid(s string) bool {
	inputLen := len(s)
	if inputLen == 0 {
		return true
	}

	if inputLen < 1 || inputLen%2 != 0 {
		return false
	}

	stack := new(Stack)
	stack.Init(len(s))
	for _, rune := range s {
		sc, noData := stack.Peek()
		if noData != nil {
			stack.Push(rune)
		} else {
			if isPair(sc, rune) {
				stack.Pop()
			} else {
				stack.Push(rune)
			}
		}
	}

	return stack.Size() == 0
}

func isPair(open rune, close rune) bool {
	return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}')
}
