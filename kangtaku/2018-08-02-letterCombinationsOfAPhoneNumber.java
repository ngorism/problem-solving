class Solution {
    List<String> ans;
    String[] keys = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<char[]> ck;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        ck = new ArrayList<>();
        if (digits.length() == 0) return ans;
        for (String key : keys) {
            char[] ckey = key.toCharArray();
            ck.add(ckey);
        }
        dfs(digits.toCharArray(), 0, "");
        return ans;
    }
    
    public void dfs(char[] cs, int x, String s) {
        if (x == cs.length) {
            ans.add(s);
            return;
        }
        
        int idx = cs[x] - '0';
        for (int i = 0; i < ck.get(idx).length; i++) {
            char c = ck.get(idx)[i];
            dfs(cs, x + 1, s + String.valueOf(c));
        }
    }
}
