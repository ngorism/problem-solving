package p2018_08_28;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MostProfitAssigningWork {

	public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

		int sum = 0;

		int maxIdx = -1;
		int[] profitCnt = new int[profit.length];

		for (int i=0;i<worker.length;i++) {

			maxIdx = -1;
			for (int j=0;j<difficulty.length;j++) {
				if (worker[i] >= difficulty[j]) {
					if (maxIdx==-1) {
						maxIdx = j;
					}else if (profit[j] >= profit[maxIdx]) {
						maxIdx = j;
					}
				}
			}
			if (maxIdx != -1) {
				profitCnt[maxIdx]++;
			}
		}
		for (int i=0;i<profit.length;i++) {
			if (profitCnt[i] > 0) {
				sum += (profit[i]*profitCnt[i]);
			}
		}
		return sum;
	}

	@Test
	public void test() {

		assertEquals(maxProfitAssignment(
			new int[] {2,4,6,8,10},
			new int[] {10,20,30,40,50},
			new int[] {4,5,6,7}
		), 100);

		assertEquals(maxProfitAssignment(
			new int[] {85, 47, 57},
			new int[] {24, 66, 99},
			new int[] {40, 25, 25}
		), 0);
	}
}
