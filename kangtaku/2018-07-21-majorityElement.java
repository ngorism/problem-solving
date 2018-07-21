class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length, i;
        Map<Integer, Integer> mp = new HashMap<>();
        for (i = 0; i < n; i++) {
            Integer v = mp.getOrDefault(nums[i], 0);
            v++;
            mp.put(nums[i], v);
        }
        for (Integer key : mp.keySet()) {
            if (mp.get(key) > n / 2) {
                return key;
            }
        }
        return -1;
    }
}
