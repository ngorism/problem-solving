class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        int rob = nums[0], noRob = 0, n = nums.length;
        for (int i = 1; i < n; i++) {
            int t = noRob;
            noRob = rob;
            rob = Math.max(rob, t + nums[i]);
        }
        return Math.max(rob, noRob);
    }
}


