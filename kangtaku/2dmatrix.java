class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) return false;
        int m = matrix[0].length;
        int lo = 0, hi = (n * m) - 1;
        while (lo <= hi) {
            int mid = lo  + (hi - lo) / 2;
            int x = (int)Math.floor((double)mid / m);
            int y = mid - (x * m);
            if (matrix[x][y] < target) {
                lo = mid + 1;
            } else if (matrix[x][y] > target) {
                hi = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
