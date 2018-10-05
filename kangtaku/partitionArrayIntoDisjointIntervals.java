class Solution {
    public int partitionDisjoint(int[] A) {
        int n = A.length;
        int[] mins = new int[n];
        mins[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            mins[i] = Math.min(A[i], mins[i + 1]);
        }
        int max = -1;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, A[i]);
            if (max <= mins[i + 1]) {
                return i + 1;
            }
        }
        return 0;
    }
}
