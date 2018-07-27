import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())return false;
		int[] freq=new int[26];
		
		for(char c:s.toCharArray()) {
			freq[c-97]++;
		}
		for(char c:t.toCharArray()) {
			freq[c-97]--;
		}
		for(int i=0; i<26;i++) {
			if(freq[i]!=0)return false;
		}
		return true;
	}
	@Test
	public void test() {
		assertTrue(isAnagram("anagram","nagaram"));
		assertFalse(isAnagram("rat","car"));
	}
}
