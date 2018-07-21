package p2018_07_18;

/**
 * Created on 2018. 7. 21..
 */
public class ValidAnagram {

	public static void main(String[] args) {

//		String s = "anagram";
//		String t = "nagaram";

		String s = "rat";
		String t = "car";
		boolean result = new ValidAnagram().isAnagram(s, t);
		System.out.println(result);
	}

	public boolean isAnagram(String s, String t) {
		boolean result = true;
		int[] data = new int[26];

		for (int i=0;i<s.length();i++) {
			data[s.charAt(i)-'a']++;
		}
		for (int i=0;i<t.length();i++) {
			data[t.charAt(i)-'a']--;
		}
		for (int i=0;i<data.length;i++) {
			if (data[i]!=0) {
				result = false;
				break;
			}
		}
		return result;
	}
}
