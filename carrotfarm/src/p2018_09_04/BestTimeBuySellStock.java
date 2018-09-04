package p2018_09_04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BestTimeBuySellStock {

	public int maxProfit(int[] prices) {

		int max = 0;
		for (int i=0;i<prices.length;i++) {
			for (int j=i+1;j<prices.length;j++) {

				if (prices[j] - prices[i] > max) {
					max = prices[j] - prices[i];
				}
			}
		}
		return max;
	}

	@Test
	public void test() {

		assertEquals(maxProfit(new int[] {7,1,5,3,6,4}), 5);
		assertEquals(maxProfit(new int[] {7,6,4,3,1}), 0);
	}
}
