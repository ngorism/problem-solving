class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        int x = 0;
        int[] d = new int[10001];
        for (int i = 0; i < n ;i++) {
            d[deck[i]]++;
            
        }
        List<Integer> a = new ArrayList<>();
        int min = 9999999;
        for (int i = 0; i <= 10000; i++) {
            if (d[i] != 0) {
                min = Math.min(min, d[i]);
                a.add(d[i]);
                if (d[i] < 2) return false;
            }
        }
        if (a.size() == 1) return true;
        int g = gcd(a.get(0), a.get(1));
        for (int i = 2; i < a.size(); i++) {
            g = gcd(g, a.get(i));
        }
        if (g == 1) return false;
        for (Integer num : a) {
            if (num % g != 0) return false;
        }
        return true; 
    }
    public int gcd(int a, int b) {
        if(b == 0){
        return a;
    }else{
        return gcd(b, a%b);
    }
    }
}
