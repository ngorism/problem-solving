class Solution {
    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();
        
        int n = cs.length, m = ts.length;
        if (n != m) return false;
        int[] csc = new int[27];
        int[] tsc = new int[27];
        for (int i = 0; i < n; i++) {
            csc[cs[i] - 'a']++;
            tsc[ts[i] - 'a']++;
        }
        for (int i = 0; i < 27; i++) {
            if (csc[i] != tsc[i]) return false;
        }
        return true;
    }
}
