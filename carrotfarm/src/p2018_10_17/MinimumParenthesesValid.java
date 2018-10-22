package p2018_10_17;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;


public class MinimumParenthesesValid {

	public int minAddToMakeValid(String S) {

		int result = 0;
		if (S == null || S.length()==0) {
			return result;
		}
		Stack<String> stack = new Stack<>();
		for (int i=0;i<S.length();i++) {
			String s = S.charAt(i)+"";
			if (s.equals("(")) {
				stack.push(s);
			}else {

				if (stack.empty()) {
					result++;
				}else {
					stack.pop();
				}
			}
		}
		return result + stack.size();
	}

	@Test
	public void test() {

		assertEquals(minAddToMakeValid("())"), 1);
		assertEquals(minAddToMakeValid("((("), 3);
		assertEquals(minAddToMakeValid("()"), 0);
		assertEquals(minAddToMakeValid("()))(("), 4);
	}
}
