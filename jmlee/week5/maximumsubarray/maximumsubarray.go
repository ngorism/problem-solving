package maximumsubarray

import "fmt"

/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

func maxSubArray(nums []int) int {
	len := len(nums)

	var maxSum int
	var maxSubArray []int

	for i := 1; i <= len; i++ {
		chunkSize := i
		for start := 0; start <= len-chunkSize; start++ {
			subArray := nums[start : start+chunkSize]
			subArraySum := sum(subArray)
			if subArraySum > maxSum || maxSubArray == nil {
				maxSum = subArraySum
				maxSubArray = subArray
			}
		}
	}

	fmt.Printf("%v -> sum : %v\n", maxSubArray, maxSum)
	return maxSum
}

func sum(nums []int) int {
	sum := 0
	for _, value := range nums {
		sum += value
	}

	return sum
}
