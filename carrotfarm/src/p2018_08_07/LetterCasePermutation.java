package p2018_08_07;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LetterCasePermutation {

	public List<String> letterCasePermutation(String S) {

		List<String> result = new ArrayList<>();

		search(S.toCharArray(), 0, result);

		result.stream().forEach(s-> System.out.println(s));

		return result;
	}

	private void search(char[] S, int idx, List<String> result) {

		if (idx == S.length) {
			result.add(String.valueOf(S));
			return;
		}
		char c = S[idx];

		search(S, idx+1, result);

		if ('a' <= c && c <= 'z') {

			S[idx] += ('A'-'a');
			search(S, idx+1, result);
		}else if ('A' <= c && c <= 'Z') {

			S[idx] -= ('A'-'a');
			search(S, idx+1, result);
		}
	}

	@Test
	public void test() {


//		letterCasePermutation("a1b2");
//		letterCasePermutation("3z4");
		letterCasePermutation("12345");
	}
}
