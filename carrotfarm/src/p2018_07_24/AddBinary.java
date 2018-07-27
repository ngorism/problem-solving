package p2018_07_24;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created on 2018. 7. 21..
 */
public class AddBinary {


	public String addBinary(String a, String b) {

		int length = Math.max(a.length(), b.length());

		int resv = 0;
		StringBuffer sb = new StringBuffer();
		for (int i=0;i<length;i++) {

			int val = resv;
			if (i < a.length()) {
				val += a.charAt(a.length() - 1 - i) - '0';
			}
			if (i < b.length()) {
				val += b.charAt(b.length() - 1 - i) - '0';
			}
			sb.append(val % 2);
			resv = val / 2;
		}
		if (resv==1) {
			sb.append(resv);
		}

		return sb.reverse().toString();
	}

	@Test
	public void test() {
//		System.out.println(addBinary("11", "1"));
//		System.out.println(addBinary("1010", "1011"));

		assertEquals(addBinary("11", "1"), "100");
		assertEquals(addBinary("1010", "1011"), "10101");
	}
}
