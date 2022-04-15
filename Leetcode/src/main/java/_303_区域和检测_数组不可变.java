public class _303_区域和检测_数组不可变 {

    static int[] preSum;
    public _303_区域和检测_数组不可变(int[] nums) {
        preSum = new int[nums.length+1];
        for (int i = 1; i <nums.length+1 ; i++) {
            preSum[i] = nums[i-1] + preSum[i-1];
        }
    }

    public int sumRange(int left, int right) {
        return preSum[right+1] - preSum[left];
    }

}
