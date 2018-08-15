class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int i, j, n = matrix.length, m = matrix[0].length;
        int[][] ans = new int[n][m];
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                ans[i][j] = Integer.MAX_VALUE - 12313131;
            }
        }
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (matrix[i][j] == 0) ans[i][j] = 0;
                if (i > 0) ans[i][j] = Math.min(ans[i][j], ans[i - 1][j] + 1);
                if (j > 0) ans[i][j] = Math.min(ans[i][j], ans[i][j - 1] + 1);
            }
        }
        for (i = n - 1; i >= 0; i--) {
            for (j = m - 1; j >= 0; j--) {
                if (i < n - 1) ans[i][j] = Math.min(ans[i][j], ans[i + 1][j] + 1);
                if (j < m - 1) ans[i][j] = Math.min(ans[i][j], ans[i][j + 1] + 1);
            }
        }
        return ans;
    }
}
