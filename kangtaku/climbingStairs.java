class Solution {
    int[] cache;
    public int climbStairs(int n) {
        cache = new int[n + 1];
        return solve(n);
    }
    public int solve(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (cache[n] != 0) return cache[n];
        int res = 0;
        res = solve(n - 1) + solve(n - 2);
        cache[n] = res;
        return res;
    }
}
