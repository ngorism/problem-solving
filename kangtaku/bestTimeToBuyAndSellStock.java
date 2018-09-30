class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, ans = 0;
        for (int i = 0; i < n; i++) {
            if (min > prices[i]) {
                min = prices[i];
                max = min;
            }
            if (max < prices[i]) {
                max = prices[i];
            }
            ans = Math.max(ans, max - min);
        }
        return ans;
    }
}
