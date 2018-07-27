package p2018_07_24;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import org.junit.Test;

/**
 * Created on 2018. 7. 21..
 */
public class ValidParentheses {


	public boolean isValid(String s) {

		Map<Character, Character> matchMap = new HashMap<>();
		matchMap.put('(', ')');
		matchMap.put('[', ']');
		matchMap.put('{', '}');

		Set<Character> openSet = matchMap.keySet();
		Stack<Character> stack = new Stack<>();

		for (int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if (openSet.contains(c)) {
				stack.push(c);
			}else {
				if (stack.empty()) {
					return false;
				}
				Character pre = stack.pop();
				if (matchMap.get(pre) != c ) {
					return false;
				}
			}
		}
		if (!stack.empty()) {
			return false;
		}
		return true;
	}

	@Test
	public void test() {

		assertTrue(isValid("()"));
		assertTrue(isValid("()[]{}"));
		assertFalse(isValid("(]"));
		assertFalse(isValid("([)]"));
		assertTrue(isValid("{[]}"));

		assertTrue(isValid("([{}])"));

	}
}
