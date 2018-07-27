
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddBinary {
    public String addBinary(String a, String b) {
        //String ret = "";
        StringBuilder ret = new StringBuilder();
        int lenA = a.length(), lenB = b.length();
        char pre = '0';
        for (int i = lenA - 1, j = lenB - 1; i >= 0 || j >= 0;) {
            char A = i >= 0 ? a.charAt(i--) : '0';
            char B = j >= 0 ? b.charAt(j--) : '0';
            int num=A+B+pre;
            ret.insert(0, (char) (num % 2 + '0'));
            pre = (char) ((num / 146) + '0');
        }
        ret.insert(0,pre=='1'?'1':"");
        return ret.toString();
    }

    @Test
    public void test() {
        assertEquals("10101", addBinary("1010", "1011"));
        assertEquals("100", addBinary("11", "1"));
    }
}
