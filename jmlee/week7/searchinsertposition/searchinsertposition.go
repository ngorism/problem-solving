package searchinsertposition

func searchInsert(nums []int, target int) int {
	return find(nums, target, 0, len(nums)-1)
}

func find(nums []int, target int, left int, right int) int {
	center := ((right - left) / 2) + left
	if nums[center] == target {
		return center
	} else if right-left <= 1 {
		if nums[right] == target {
			return right
		} else if target < nums[left] {
			return left
		} else if target > nums[right] {
			return right + 1
		} else {
			return right
		}
	} else if nums[center] < target {
		return find(nums, target, center, right)
	} else if nums[center] > target {
		return find(nums, target, left, center)
	} else {
		return -1
	}
}
