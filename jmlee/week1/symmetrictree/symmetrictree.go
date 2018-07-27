package symmetrictree

import (
	"fmt"
)

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func PrintTree(root *TreeNode) {
	if root == nil {
		return
	}

	fmt.Println(root.Val)
	PrintTree(root.Left)
	PrintTree(root.Right)
}

func Add(root *TreeNode, val int) *TreeNode {
	if root == nil {
		root = new(TreeNode)
		root.Val = val
		return root
	}

	if val >= root.Val {
		return AddNode(root, root.Right, val)
	} else {
		return AddNode(root, root.Left, val)
	}
}

func AddNode(parent *TreeNode, current *TreeNode, val int) *TreeNode {

	if current == nil {
		current = new(TreeNode)
		current.Val = val
		if current.Val >= parent.Val {
			parent.Right = current
		} else {
			parent.Left = current
		}
		return current
	}

	if val >= current.Val {
		return AddNode(current, current.Right, val)
	} else {
		return AddNode(current, current.Left, val)
	}
}

// IsSymmetric returns whether the root node is symmetric tree or not.
func IsSymmetric(root *TreeNode) bool {
	if root == nil {
		return false
	}
	return isMirror(root.Left, root.Right)
}

func isMirror(left *TreeNode, right *TreeNode) bool {
	if left == nil && right == nil {
		return true
	} else if left != nil && right != nil {
		if left.Val == right.Val {
			return isMirror(left.Left, right.Right) && isMirror(left.Right, right.Left)
		} else {
			return false
		}
	} else {
		return false
	}
}

func isLeaf(node *TreeNode) bool {
	return node.Left == nil && node.Right == nil
}
