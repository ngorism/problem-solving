class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length, i, j;
        int[] d = new int[amount + 1];
        Arrays.fill(d, 99999999);
        d[0] = 1;
        for (i = 0; i <= amount; i++) {
            for (j = 0; j < n; j++) {
                if (coins[j] > i) continue;
                d[i] = Math.min(d[i], d[i - coins[j]] + 1);
            }
        }
        return d[amount] == 99999999 ? -1 : ((int)d[amount] - 1);
    }
}
