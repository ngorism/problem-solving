class Solution {
    public int findLength(int[] A, int[] B) {
        int n = A.length, m = B.length, i, j, ans = 0;
        int[][] d = new int[2][m];
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (i == 2 && j == 1) System.out.println(A[i] + ", " + B[j]);
                if ((i == 0 || j == 0) && A[i] == B[j]) d[i % 2][j] = 1;
                else if (A[i] == B[j]) {
                    d[i % 2][j] = d[(i - 1) % 2][j - 1] + 1;
                    ans = Math.max(ans, d[i % 2][j]);
                } else if (A[i] != B[j]) d[i % 2][j] = 0;
            }
        }
        return ans;
    }
}
