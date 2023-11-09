public class LCR_008_长度最小的子数组 {

    /**
     * 这题抓住题眼: 子数组之和
     *  这时候得立刻联系到前缀和;
     *  然后发现可以结合滑动窗口(变长)解决
     *
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
//        int[] presum = new int[n];
//        presum[0]=nums[0];
//        for (int i = 1; i < n; i++) {
//            presum[i]=presum[i-1]+ nums[i];
//        }
        int res = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int j = 0; j <n; j++) {
            sum += nums[j];
            while(sum>=target){
                res = Math.min(res, j-left+1);
                sum -= nums[left++];
            }
        }
        return res<Integer.MAX_VALUE ? res : 0;
    }
}
