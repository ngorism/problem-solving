package p2018_09_12;

import static org.junit.Assert.assertArrayEquals;

import com.sun.tools.javac.util.ArrayUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class IntersectionTwoArrays2 {


	public int[] intersect(int[] nums1, int[] nums2) {

		List<Integer> result = new ArrayList<>();
		if (nums1==null || nums2==null) {
			return null;
		}
		Arrays.sort(nums1);
		Arrays.sort(nums2);

		int header = 0;

		for (int i=0;i< nums1.length;i++) {
			if (header >= nums2.length) {
				break;
			}

			if (nums1[i] < nums2[header]) {
				continue;
			}else if (nums1[i] == nums2[header]) {
				result.add(nums1[i]);
				header++;
			}else {
				i--;
				header++;
			}
		}

		return result.stream().mapToInt(i->i).toArray();
	}

	@Test
	public void test() {

		assertArrayEquals(intersect(
			new int[] {1,2,2,1}, new int[] {2,2}
		), new int[] {2,2});

		assertArrayEquals(intersect(
			new int[] {4,9,5}, new int[] {9,4,9,8,4}
		), new int[] {4,9});
	}

}
