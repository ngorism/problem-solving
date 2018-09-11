package main

import "fmt"

func climbStairs(n int) int {
	if n <= 2 {
		return n
	}

	dp1 := 1
	dp2 := 2
	for i := 2; i < n; i++ {
		dp1, dp2 = dp2, dp1+dp2
	}

	return dp2
}

func main() {
	fmt.Println("ways: ", climbStairs(4))
}
