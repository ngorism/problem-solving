package twosum

func twoSum(nums []int, target int) []int {
	ret := make([]int, 2)
	for x, vx := range nums {
		for y, vy := range nums {
			if x == y {
				continue
			}

			if (vx + vy) == target {
				ret[0] = x
				ret[1] = y
				return ret
			}
		}
	}

	return ret
}
