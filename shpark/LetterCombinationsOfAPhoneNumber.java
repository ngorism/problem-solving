import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    char[][] phoneLetter = new char[][]{
            {},
            {},
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.length() < 1) return ret;
        ret.add("");
        for (char c : digits.toCharArray()) {
            List<String> newRet = new ArrayList<>();
            for (char x : phoneLetter[c - '0']) {
                for (String s : ret)
                    newRet.add(s + x);
            }
            ret = newRet;
        }
        return ret;
    }
}
