public class _334_递增的三元子序列 {

    /**
     * 这题要求数组中存在一个递增的三元组
     *  -- 即存在一个元素num[i], 下标i之前存在一个小于它的元素, 下标i之后存在一个大于它的元素
     *  那么可以借助两个辅助数组: 最小前缀数组preMin[]和最大后缀数组sufMax[]
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int len = nums.length;;
        int[] preMin = new int[len];
        int[] sufMax = new int[len];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            min= Math.min(min, nums[i]);
            max= Math.max(max, nums[len-i-1]);
            preMin[i] = min;
            sufMax[len-i-1] = max;
        }
        for (int i = 1; i <len-1; i++) {
            if (nums[i]>preMin[i-1] && nums[i]<sufMax[i+1])
                return true;
        }
        return false;
    }

    /**
     * Leetcode官方给出了一个贪心的解法;
     *      初始时，first=nums[0]fsecond=+∞，然后从1开始遍历数组;
     *      当遍历到下标 i 时，令 num=nums[i]，随后进行如下操作：
     *          如果 num>second，则找到了一个递增的三元子序列，返回true；
     *          否则，如果 num>first，则将 second的值更新为 num；
     *          否则，将 first的值更新为 num。
     *      如果遍历结束时没有找到递增的三元子序列，返回 false。
     *
     * 上述做法的贪心思想是：为了找到递增的三元子序列，第一和第二个数first和second 应该尽可能地小，
     * 此时找到递增的三元子序列的可能性更大。
     */
    public boolean increasingTriplet_2(int[] nums) {
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num> second){
                return true;
            }else if (num< first){
                first = num;
            }else {
                second = num;
            }
        }
        return false;
    }
}
