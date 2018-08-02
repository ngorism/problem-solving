package main

import "fmt"

func main() {
	slice := make([]int, 5, 10)
	fmt.Printf("len %v, cap %v", len(slice), cap(slice))

	
}
