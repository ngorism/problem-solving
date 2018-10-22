package p2018_10_17;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Test;


public class TopKFrequentWord {


	public List<String> topKFrequent(String[] words, int k) {

		int cnt = 0;
		List<String> result = new ArrayList<>();
		Map<String, Integer> wordMap = new HashMap<>();
		for (int i=0;i<words.length;i++) {
			cnt = wordMap.getOrDefault(words[i], 0);
			wordMap.put(words[i], cnt+1);
		}

		List<Map.Entry<String, Integer>> entryList = new ArrayList<>(wordMap.entrySet());
		Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

				if (o1.getValue().compareTo(o2.getValue()) == 0) {
					return o1.getKey().compareTo(o2.getKey());
				}
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		for (int i=0;i<entryList.size() && i<k;i++) {
			result.add(entryList.get(i).getKey());
			System.out.println(entryList.get(i).getKey());
		}

		return result;
	}

	@Test
	public void test() {

//		assertEquals(topKFrequent(new String[] {"i", "love", "leetcode", "i", "love", "coding"}, 2),
//			Arrays.asList("i", "love"));

		assertEquals(topKFrequent(new String[] {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4),
			Arrays.asList("the", "is", "sunny", "day"));

	}
}
