class Solution {
    public boolean canJump(int[] nums) {
        int i, j, now = 0, beforeMax = -1;
        boolean moved = true;
        while (now < nums.length - 1 && now + nums[now] < nums.length - 1) {
            int max = now, maxIdx = now;
            for (i = now; i < nums.length && i <= now + nums[now]; i++) {
                if (max < i + nums[i]) {
                    max = i + nums[i];
                    maxIdx = i;
                }
            }
            if (now == maxIdx) {
                return false;
            }
            now = maxIdx;
        }
        return true;
    }
}
