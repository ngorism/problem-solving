import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertTrue;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='{')stack.push('}');
            else if (c=='[') stack.push(']');
            else if (c=='(') stack.push(')');
            else if(stack.isEmpty() || c!=stack.pop())return false;
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        assertTrue(isValid("{[]}"));
    }
}
