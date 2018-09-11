package main

import "fmt"

func canJump(nums []int) bool {
	length := len(nums)
	if length == 1 {
		return true
	} else if nums[0] == 0 && length > 1 {
		return false
	}

	maxJump := nums[0]
	for i := 1; i < length-1; i++ {
		next := nums[i] + i
		if next > maxJump {
			maxJump = next
		}

		if nums[i] == 0 && i >= maxJump {
			return false
		}
	}

	return true
}

func main() {
	nums := []int{2, 3, 1, 1, 4}
	res := canJump(nums)
	if canJump(nums) != true {
		fmt.Println("nums:", nums, res)
	}

	nums = []int{3, 2, 1, 0, 4}
	res = canJump(nums)
	if canJump(nums) != false {
		fmt.Println("nums:", nums, res)
	}

	nums = []int{1, 1, 1, 0}
	res = canJump(nums)
	if canJump(nums) != true {
		fmt.Println("nums:", nums, res)
	}

	nums = []int{0, 1}
	res = canJump(nums)
	if canJump(nums) != false {
		fmt.Println("nums:", nums, res)
	}

}
