import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import org.junit.Test;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}
	@Test
	public void test() {
		assertEquals(3,majorityElement(new int[] {3,2,3}));
		assertEquals(2,majorityElement(new int[] {2,2,1,1,1,2,2}));
	}
}
