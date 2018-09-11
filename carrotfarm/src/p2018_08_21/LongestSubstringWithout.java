package p2018_08_21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestSubstringWithout {

	public int lengthOfLongestSubstring(String s) {

		if (s==null || s.length()==0) {
			return 0;
		}

		int maxLength = 0;
		int startOffset = 0;

		String subStr = "";
		for (int i=1;i<s.length();i++) {

			subStr = s.substring(startOffset, i);

			int idx = s.indexOf(s.charAt(i), startOffset);
			if (i != idx) {
				startOffset = idx+1;
				if (subStr.length() > maxLength) {
//					System.out.println("renewal : " + subStr);
					maxLength = subStr.length();
				}
			}
		}
		subStr = s.substring(startOffset, s.length());
		if (subStr.length() > maxLength) {
			System.out.println("final : " + subStr);
			maxLength = subStr.length();
		}
		return maxLength;
	}

	@Test
	public void test() {
		assertEquals(lengthOfLongestSubstring(" "), 1);
		assertEquals(lengthOfLongestSubstring("au"), 2);
		assertEquals(lengthOfLongestSubstring("dvdf"), 3);
		assertEquals(lengthOfLongestSubstring("abcabcbb"), 3);
		assertEquals(lengthOfLongestSubstring("bbbbb"), 1);
		assertEquals(lengthOfLongestSubstring("pwwkew"), 3);
	}
}
