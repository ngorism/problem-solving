public class MissingNumber {
    public int missingNumber(int[] nums) {
        int ret=nums.length;
        for(int i=0;i<nums.length;i++){
            ret+=i;
            ret-=nums[i];
        }
        return ret;
    }
}
