package p2018_10_02;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


public class XDeckCards {

	// Wrong Answer
	public boolean hasGroupsSizeX(int[] deck) {

		Map<Integer, Integer> cntMap = new HashMap<>();

		for (int i=0;i<deck.length;i++) {
			cntMap.put(deck[i], cntMap.getOrDefault(deck[i], 0)+1);
		}

		Map<Integer, Integer> sortedMap =
				cntMap.entrySet().stream()
						.sorted(Map.Entry.comparingByValue())
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
								(e1, e2) -> e1, LinkedHashMap::new));

		int minCnt = -1;
		Iterator<Integer> iter = sortedMap.values().iterator();
		while(iter.hasNext()) {
			if (minCnt == -1) {
				minCnt = iter.next();
				continue;
			}
			if ((minCnt % 2 == 0 && iter.next().intValue() % 2 != 0 ) ||
				(minCnt % 2 == 1 && iter.next().intValue() % minCnt != 0 )) {
				return false;
			}
		}

		return minCnt != 1;
	}

	@Test
	public void test() {

		assertEquals(hasGroupsSizeX(new int[] {1,2,3,4,4,3,2,1}), true);
		assertEquals(hasGroupsSizeX(new int[] {1,1,1,2,2,2,3,3}), false);
		assertEquals(hasGroupsSizeX(new int[] {1}), false);
		assertEquals(hasGroupsSizeX(new int[] {1,1}), true);
		assertEquals(hasGroupsSizeX(new int[] {1,1,2,2,2,2}), true);

		assertEquals(hasGroupsSizeX(new int[] {1,1,1,1,2,2,2,2,2,2}), true);
		assertEquals(hasGroupsSizeX(new int[] {0,0,0,1,1,1,2,2,2}), true);

	}

}
