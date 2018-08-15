class Solution {
    List<String> ans;
    public List<String> letterCasePermutation(String S) {
        ans = new ArrayList<>();
        find(S.toCharArray(), 0);
        return ans;
    }
    public void find(char[] S, int x) {
        ans.add(new String(S));
        for (int i = x; i < S.length; i++) {
            if (!Character.isDigit(S[i])) {
                change(S, i);
                find(S, i + 1);
                change(S, i);
            }
        }
    }
    
    public void change(char[] S, int x) {
        int t;
        if (Character.isUpperCase(S[x])) {
            t = S[x] - 'A';
            S[x] = (char)('a' + t);
        } else {
            t = S[x] - 'a';
            S[x] = (char)('A' + t);
        }
    }
}
