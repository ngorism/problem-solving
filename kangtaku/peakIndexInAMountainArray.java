class Solution {
    public int peakIndexInMountainArray(int[] A) {
        int lo = 0, hi = A.length - 1;
		int mid;

		while (lo <= hi) {
			mid = lo + (hi - lo) / 2;
			if (A[mid] < A[mid + 1]) {
				lo = mid + 1;
			} else {
				hi = mid - 1;
			}
		}
		return lo;
    }
}
