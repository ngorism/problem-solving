class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length, lo = 0, hi = 0, t;
        while (hi < n) {
            if (nums[hi] != 0) {
                t = nums[hi];
                nums[hi] = nums[lo];
                nums[lo] = t;
                lo++;
            }
            hi++;
        }
        while (lo < n) {
            nums[lo++] = 0;
        }
    }
}
