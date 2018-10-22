package p2018_10_17;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;


public class UniqueMorseCode {

	public int uniqueMorseRepresentations(String[] words) {

		Set<String> transSet = new HashSet<>();
		String[] morseList = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

		String word = "";
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<words.length;i++) {
			word = words[i];
			sb.setLength(0);
			for (int j=0;j<word.length();j++) {
				int idx = word.charAt(j) - 'a';
				sb.append(morseList[idx]);
			}
			transSet.add(sb.toString());
		}
		return transSet.size();
	}

	@Test
	public void test() {

		assertEquals(uniqueMorseRepresentations(new String[] {
			"gin", "zen", "gig", "msg"
		}), 2);

	}
}
