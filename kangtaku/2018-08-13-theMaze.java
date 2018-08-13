class Solution {
    int[][] v;
    int[][] arrs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    int n, m;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        n = maze.length;
        m = maze[0].length;
        v = new int[n][m];
        return can(maze, start[0], start[1], destination);
    }
    
    public boolean can(int[][] maze, int x, int y, int[] dest) {
        if (x == dest[0] && y == dest[1]) return true;
        if (v[x][y] == 1) return false;
        v[x][y] = 1;
        int ax, ay;
        for (int[] arr : arrs) {
            for (int go = 1;; go++) {
                ax = x + (arr[0] * go);
                ay = y + (arr[1] * go);
                if (ax == n || ay == m || ax == -1 || ay == -1 || maze[ax][ay] == 1) {
                    ax -= arr[0];
                    ay -= arr[1];
                    if (can(maze, ax, ay, dest)) {
                        return true;
                    }
                    break;
                }
            }
        }
        return false;
    }
}
