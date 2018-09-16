class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int ans = 0, n = piles.length, lo  = 1, hi = 10000000;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (isValid(piles, mid, H)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    public boolean isValid(int[] piles, int K, int H) {
        int cnt = 0, i;
        for (i = 0; i < piles.length; i++) {
            cnt += Math.ceil((double)piles[i] / K);
        }
        return cnt <= H;
    }
}
