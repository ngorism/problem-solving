class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int[] ans = null;
        int n = nums.length, i;
        for (i = 0; i < n; i++) {
            int num = nums[i];
            if (mp.containsKey(num)) {
                ans = new int[]{i, mp.get(num)};
                break;
            }
            mp.put(target - num, i);
        }
        Arrays.sort(ans);
        return ans;
    }
}
