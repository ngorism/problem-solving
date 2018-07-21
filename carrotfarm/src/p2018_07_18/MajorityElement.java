package p2018_07_18;

import java.util.HashMap;

/**
 * Created on 2018. 7. 21..
 */
public class MajorityElement {

	public static void main(String[] args) {


		int[] nums = {2,2,1,1,1,2,2};

		int result = new MajorityElement().majorityElement(nums);
		System.out.println(result);
	}

	public int majorityElement(int[] nums) {

		HashMap<Integer, Integer> cntMap = new HashMap<Integer, Integer>(nums.length);

		for (int i=0;i<nums.length;i++) {

			Integer value = cntMap.containsKey(nums[i])?cntMap.get(nums[i]):0;
			value += 1;
			if (value > nums.length/2) {
				return nums[i];
			}
			cntMap.put(nums[i], value);
		}
		return 0;
	}
}
