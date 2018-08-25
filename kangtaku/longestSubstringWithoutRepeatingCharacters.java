class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> mp = new HashMap<>();
        int lo = 0, hi = 1, ans = 1, i, cnt, n = cs.length;
        if (n == 0) return 0;
        mp.put(cs[lo], 1);
        while (lo != n && hi != n) {
            cnt = 0;
            for (Map.Entry<Character, Integer> es : mp.entrySet()) {
                cnt += es.getValue();
            }
            ans = Math.max(ans, cnt);
            if (hi < n && mp.getOrDefault(cs[hi], 0) == 1) {
                mp.put(cs[lo++], 0);
            } else if (hi < n) {
                mp.put(cs[hi++], 1);
            }
        }
        cnt = 0;
        for (Map.Entry<Character, Integer> es : mp.entrySet()) {
            cnt += es.getValue();
        }
            ans = Math.max(ans, cnt);
        return ans;
    }
}
