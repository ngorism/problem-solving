class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] mors = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Map<String, Integer> mp = new HashMap<>();
        for (String word : words) {
            char[] cs = word.toCharArray();
            String str = "";
            for (char c : cs) {
                str += mors[c - 'a'];
            }
            Integer v = mp.getOrDefault(str, 0);
            mp.put(str, v + 1);
        }
        
        return mp.size();
    }
}
