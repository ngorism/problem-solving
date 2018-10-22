class Solution {
public:
    int findCircleNum(vector<vector<int>>& M) {
        int ans = 0;
        vector<bool> v(M.size(), false);
        for (int i = 0; i < M.size(); i++) {
            if (!v[i]) {
                v[i] = true;
                ans++;
                visitFriends(M, v, i);
            }
        }
        return ans;
    }
    
    void visitFriends(vector<vector<int>>& M, vector<bool>& v, int x) {
        for (int i = 0; i < M.size(); i++) {
            if (!v[i] && M[x][i]) {
                v[i] = true;
                visitFriends(M, v, i);
            }
        }
    }
};
