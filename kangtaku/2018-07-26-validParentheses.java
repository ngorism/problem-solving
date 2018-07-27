class Solution {
    public boolean isValid(String s) {
        char[] cs = s.toCharArray();
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < cs.length; i++) {
            char c = cs[i];
            if (i == 0 || c == '(' || c == '[' || c == '{') {
                st.push(cs[i]);
                continue;
            }
            if (st.isEmpty()) return false;
            char top = st.pop();
            if ((c == ']' && top == '[') || (c == ')' && top == '(') || (c == '}' && top == '{')) {
                continue;
            } else return false;
        }
        return st.isEmpty();
    }
}
