package p2018_08_01;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class LetterCombinationPhoneNumber {

	private static final Map<String, String> lettetMap = new HashMap<String, String>();
	static {
		lettetMap.put("2", "abc");
		lettetMap.put("3", "def");
		lettetMap.put("4", "ghi");
		lettetMap.put("5", "jkl");
		lettetMap.put("6", "mno");
		lettetMap.put("7", "pqrs");
		lettetMap.put("8", "tuv");
		lettetMap.put("9", "wxyz");
	}

	private static String digits = "";
	private static  List<String> result = new ArrayList<>();;

	public List<String> letterCombinations(String digits) {

		this.digits = digits;
		result.clear();
		if (digits.length() < 1) {
			return result;
		}
		letterBFS(0, "");

		return result;
	}

	private void letterBFS(int depth, String path) {

		if (depth == digits.length() ) {
			result.add(path);
			return;
		}

		String letters = lettetMap.get(digits.charAt(depth++)+"");

		for (int i=0;i<letters.length();i++) {
			letterBFS(depth, path + letters.charAt(i));
		}
	}

	@Test
	public void test() {
		assertEquals(letterCombinations(""), new ArrayList<>());
		assertEquals(letterCombinations("23"), Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
		assertEquals(letterCombinations("23"), Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
	}
}
