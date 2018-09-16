class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<Integer> ansLst = new ArrayList<>();
        int v;
        for (int num : nums1) {
            v = mp.getOrDefault(num, 0);
            mp.put(num, v + 1);
        }
        for (int num : nums2) {
            if (mp.containsKey(num) && mp.get(num) > 0) {
                v = mp.get(num);
                ansLst.add(num);
                mp.put(num, v - 1);
            }
        }
        int[] ans = new int[ansLst.size()];
        for (int i = 0; i < ansLst.size(); i++) {
            ans[i] = ansLst.get(i);
        }
        return ans;
    }
}
