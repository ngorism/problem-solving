package missingnumber

/*
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
*/
func missingNumber(nums []int) int {
	hasNumber := make([]bool, len(nums)+1)
	for _, number := range nums {
		hasNumber[number] = true
	}

	for i, occupied := range hasNumber {
		if !occupied {
			return i
		}
	}
	return 0
}
