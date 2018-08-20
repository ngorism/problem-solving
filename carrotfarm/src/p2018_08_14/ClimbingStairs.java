package p2018_08_14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ClimbingStairs {

//	1 : 1
//	2 : 2
//	3 : 3   1 에서 직접 2 step 으로 넘어온 경우 + 2에서 1 step 으로 온 경우
//	4 : 5
//			2:1,1,   2
//			2:2,     2
//			3:1,1,1, 1
//			3:1,2,   1
//			3:2,1,   1

	public int climbStairs(int n) {

		int result = 0;

		int n_2 = 1;
		int n_1 = 2;
		if (n==1) return n_2;       // Given n will be a positive integer.
		if (n==2) return n_1;

		for (int i=3;i<=n;i++) {
			result = n_1 + n_2;
			n_2 = n_1;
			n_1 = result;
		}
		return result;
	}

	@Test
	public void test() {

		assertEquals(climbStairs(2), 2);
		assertEquals(climbStairs(3), 3);
		assertEquals(climbStairs(4), 5);
	}
}
