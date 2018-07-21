class Solution {
    public boolean reorderedPowerOf2(int N) {
        int powered = 1, i, j;
        int[] nCnt = new int[10];
        char[] ncs = String.valueOf(N).toCharArray();
        for (i = 0; i < ncs.length; i++) {
            nCnt[ncs[i] - '0']++;
        }
        for (i = 0; i < 31; i++) {

            char[] cs = String.valueOf(powered).toCharArray();
            int[] pCnt = new int[10];
            for (j = 0; j < cs.length; j++) {
                pCnt[cs[j] - '0']++;
            }
            boolean isOkay = true;
            for (j = 0; j < 10; j++) {
                if (pCnt[j] != nCnt[j]) {
                    isOkay = false;
                    break;
                }
            }
            if (isOkay) return true;
            powered = powered << 1;
        }
        return false;
    }
}
