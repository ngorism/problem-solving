package main

import "fmt"

func maxSubArray2(nums []int) int {
	numsLen := len(nums)
	if numsLen == 0 {
		return 0
	}

	maxSum := nums[0]
	for i := 0; i < numsLen-1; i++ {
		subSum := 0
		for j := i; j < numsLen; j++ {
			fmt.Println(nums[i], nums[j], maxSum)
			subSum += nums[j]
			if maxSum < subSum {
				maxSum = subSum
			}
		}

	}

	return maxSum
}

func maxSubArray(nums []int) int {
	numsLen := len(nums)
	if numsLen == 0 {
		return 0
	}

	max := nums[0]
	sum := max

	for _, n := range nums[1:] {
		if sum+n > n {
			sum += n
		} else {
			sum = n
		}

		if max < sum {
			max = sum
		}
	}

	return max
}

func main() {
	nums := []int{-2, 1, -3, 4, -1, 2, 1, -5, 4}
	if maxSum := maxSubArray(nums); maxSum != 6 {
		fmt.Println("maxSum:", maxSum)
	}

	nums = []int{1, 2}
	if maxSum := maxSubArray(nums); maxSum != 3 {
		fmt.Println("maxSum:", maxSum)
	}

}
