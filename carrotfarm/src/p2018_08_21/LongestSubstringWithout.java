package p2018_08_21;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestSubstringWithout {

	public int lengthOfLongestSubstring(String s) {

		return 0;
	}

	@Test
	public void test() {

		assertEquals(lengthOfLongestSubstring("abcabcbb"), 3);
		assertEquals(lengthOfLongestSubstring("bbbbb"), 1);
		assertEquals(lengthOfLongestSubstring("pwwkew"), 3);
	}
}
