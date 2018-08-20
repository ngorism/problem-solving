class Solution {
    int[][] cache;
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if (n == 0) return 0;
        int m = grid[0].length;
        cache = new int[n][m];
        return solve(0, 0, grid);
    }
    public int solve(int x, int y, int[][] grid) {
        if (x == grid.length || y == grid[0].length) return 999999999;
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }
        if (cache[x][y] != 0) return cache[x][y];
        int res = grid[x][y];
        res += Math.min(solve(x + 1, y, grid), solve(x, y + 1, grid));
        cache[x][y] = res;
        return res;
    }
}
