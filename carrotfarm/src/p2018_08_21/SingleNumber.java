package p2018_08_21;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

public class SingleNumber {

	public int singleNumber(int[] nums) {

		Set<Integer> numSet = new HashSet<>();
		Arrays.stream(nums).forEach(n->{
			if (numSet.contains(n)) {
				numSet.remove(n);
			}else {
				numSet.add(n);
			}
		});
		return numSet.iterator().next();
	}

	@Test
	public void test() {

		assertEquals(singleNumber(new int[] {2, 2, 1}), 1);
		assertEquals(singleNumber(new int[] {4,1,2,1,2}), 4);
	}
}
