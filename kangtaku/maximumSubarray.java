class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, now = nums[0], ans = nums[0];
        for (int i = 1; i < n; i++) {
            if (now < 0) now = 0;
            now += nums[i];
            ans = Math.max(ans, now);
        }
        return ans;
    }
}
