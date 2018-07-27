class Solution {
    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        char[] t;
        reverse(ac);
        reverse(bc);
        if (ac.length < bc.length) {
            t = ac;
            ac = bc;
            bc = t;
        }
        int n = ac.length, m = bc.length, z = 0;
        char[] ans = new char[n];
        for (int i = 0; i < m; i++) {
            if (ac[i] == '1' && bc[i] == '1') {
                ans[i] = (char) ('0' + z);
                z = 1;
            } else if (ac[i] == '0' && bc[i] == '0') {
                ans[i] = (char) ('0' + z);
                z = 0;
            } else {
                if (z == 1) {
                    ans[i] = '0';
                    z = 1;
                } else ans[i] = '1';
            }
        }
        for (int i = m; i < n; i++) {
            if (ac[i] == '1' && z == 1) {
                ans[i] = '0';
            } else if (ac[i] == '0' && z == 1) {
                ans[i] = '1';
                z = 0;
            } else {
                ans[i] = ac[i];
            }
        }
        reverse(ans);
        if (z == 1) return '1' + String.valueOf(ans);
        else return String.valueOf(ans);
    }
    
    public void reverse(char[] c) {
        int n = c.length;
        char t;
        for (int i = 0; i < n / 2; i++) {
            t = c[n - i - 1];
            c[n - i - 1] = c[i];
            c[i] = t;
        }
    }
}
