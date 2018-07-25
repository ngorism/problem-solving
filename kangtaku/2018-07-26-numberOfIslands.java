class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        int i, j, n = grid.length, m = grid[0].length, ans = 0;
        for (i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    sketch(i, j, grid);
                    ans++;
                }
            }
        }
        return ans;
    }
    
    public void sketch(int x, int y, char[][] grid) {
        if (x == -1 || y == -1 || x == grid.length || y == grid[0].length || grid[x][y] == '0') return;
        grid[x][y] = '0';
        sketch(x-1,y,grid);
        sketch(x+1,y,grid);
        sketch(x,y-1,grid);
        sketch(x,y+1,grid);
    }
}
