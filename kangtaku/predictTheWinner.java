class Solution {
    int[][] d = new int[21][21];
    public boolean PredictTheWinner(int[] nums) {
        for (int i = 0; i < 21; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        return canWin(0, nums.length - 1, nums) >= 0;
    }
    public int canWin(int lo, int hi, int[] nums) {
        if (lo > hi) return 0;
        if (d[lo][hi] != Integer.MAX_VALUE) return d[lo][hi]; 
        int res = Math.max(nums[lo] - canWin(lo + 1, hi, nums), nums[hi] - canWin(lo, hi - 1, nums));
        d[lo][hi] = res;
        return res;
    }
}
