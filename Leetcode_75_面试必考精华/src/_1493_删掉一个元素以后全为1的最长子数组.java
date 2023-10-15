public class _1493_删掉一个元素以后全为1的最长子数组 {

    /**
     * 这题和 1004.最大连续1的个数几乎一样
     *      --区别在于: 规定连续子数组中的0不多于一个, 且长度要减去这个0元素的长度
     * @param nums
     * @return
     */
    public int longestSubarray(int[] nums) {
        int left=0;
        int sum = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum+1< i-left+1){
                sum -= nums[left++];
            }
            res = Math.max(res, i-left+1);
        }
        return res -1;
    }
}
