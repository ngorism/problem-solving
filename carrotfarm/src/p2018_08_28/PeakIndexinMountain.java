package p2018_08_28;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PeakIndexinMountain {

	public int peakIndexInMountainArray(int[] A) {

		int idx = 0;
		for (int i=1; i < A.length-1; i++) {
			if (A[i-1] < A[i] && A[i] > A[i+1]) {
				idx =  i;
				break;
			}
		}
		return idx;
	}

	@Test
	public void test() {

		assertEquals(peakIndexInMountainArray(new int[] {0,1,0}), 1);
		assertEquals(peakIndexInMountainArray(new int[] {0,2,1,0}), 1);
	}
}
