package peakindex

func peakIndexInMountainArray(A []int) int {
	return find(A, 0, len(A)-1)
}

func find(A []int, left int, right int) int {
	center := ((right - left) / 2) + left
	if A[center] > A[center-1] && A[center] > A[center+1] {
		return center
	} else if A[center] > A[center-1] && A[center] < A[center+1] {
		return find(A, center, right)
	} else if A[center] < A[center-1] && A[center] > A[center+1] {
		return find(A, left, center)
	} else {
		return 0
	}
}
