package p2018_09_12;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class KokoEatingBananas {

	// discussion
	public int minEatingSpeed(int[] piles, int H) {
		int minPile = 1, maxPile = Integer.MIN_VALUE;
		for (int tmp : piles) {
			maxPile = Math.max(maxPile, tmp);
		}

		while (minPile <= maxPile) {
			int hourNeeded = 0;
			int i = minPile + (maxPile - minPile) / 2;
			for (int tmp : piles) {
				if (tmp <= i) {
					hourNeeded++;
				} else if (tmp % i != 0) {
					hourNeeded += tmp / i + 1;
				} else {
					hourNeeded += tmp / i;
				}
			}
			if (hourNeeded <= H) {
				maxPile = i - 1;
			}
			else {
				minPile = i + 1;
			}
		}

		return minPile;
	}

	@Test
	public void test() {

		assertEquals(minEatingSpeed(new int[] {3,6,7,11},8), 4);
		assertEquals(minEatingSpeed(new int[] {30,11,23,4,20},5), 30);
		assertEquals(minEatingSpeed(new int[] {30,11,23,4,20},6), 23);
	}

}
