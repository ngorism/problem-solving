package main

import (
	"fmt"

	"github.com/jeongmin/problem-solving/jmlee/week1/anagram"
	"github.com/jeongmin/problem-solving/jmlee/week1/symmetrictree"
)

func main() {
	anagram.IsAnagram("hh", "haha")

	/*
		root := symmetrictree.Add(nil, 10)
		symmetrictree.Add(root, 5)
		symmetrictree.Add(root, 3)
		symmetrictree.Add(root, 15)
		symmetrictree.Add(root, 7)
		symmetrictree.Add(root, 12)
		symmetrictree.Add(root, 18)
	*/

	root := new(symmetrictree.TreeNode)
	root.Val = 1

	root.Left = new(symmetrictree.TreeNode)
	root.Left.Val = 2

	root.Left.Left = new(symmetrictree.TreeNode)
	root.Left.Left.Val = 3

	root.Left.Right = new(symmetrictree.TreeNode)
	root.Left.Right.Val = 4

	root.Right = new(symmetrictree.TreeNode)
	root.Right.Val = 2

	root.Right.Left = new(symmetrictree.TreeNode)
	root.Right.Left.Val = 4

	root.Right.Right = new(symmetrictree.TreeNode)
	root.Right.Right.Val = 3

	isSymmetric := symmetrictree.IsSymmetric(root)

	symmetrictree.PrintTree(root)
	fmt.Println(isSymmetric)
}
