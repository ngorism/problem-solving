class Solution {
    public int minAddToMakeValid(String S) {
        Stack<Character> st = new Stack<>();
        char[] cs = S.toCharArray();
        int i;
        for (i = 0; i < cs.length; i++) {
            if (st.size() > 0) {
                if (cs[i] == ')' && st.peek() == '(') {
                    st.pop();
                } else st.push(cs[i]);
            } else st.push(cs[i]);
        }
        return st.size();
    }
}
