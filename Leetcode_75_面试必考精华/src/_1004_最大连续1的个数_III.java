public class _1004_最大连续1的个数_III {

    /**
     * 滑动窗口 + 前缀和
     *     这一题题目可以转换为 "找到元素为0个数不超过k个的最长连续子数组, 返回其长度";
     *     又因为数组元素只含0和1, 那么数组和单调递增;
     *     且包含0 的个数为 子数组长度 - 子数组之和
     *
     * -- 最下面是一个非固定滑动窗口的代码模板
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int left=0, right=0;
        int sum = 0;
        int res = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (sum+k< right-left+1){
                sum -= nums[left++];
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }

//    def findSubArray(nums):
//    N = len(nums) # 数组/字符串长度
//            left, right = 0, 0 # 双指针，表示当前遍历的区间[left, right]，闭区间
//            sums = 0 # 用于统计 子数组/子区间 是否有效，根据题目可能会改成求和/计数
//            res = 0 # 保存最大的满足题目要求的 子数组/子串 长度
//    while right < N: # 当右边的指针没有搜索到 数组/字符串 的结尾
//    sums += nums[right] # 增加当前右边指针的数字/字符的求和/计数
//        while 区间[left, right]不符合题意: # 此时需要一直移动左指针，直至找到一个符合题意的区间
//            sums -= nums[left] # 移动左指针前需要从counter中减少left位置字符的求和/计数
//            left += 1 # 真正的移动左指针，注意不能跟上面一行代码写反
//        # 到 while 结束时，我们找到了一个符合题意要求的 子数组/子串
//            res = max(res, right - left + 1) # 需要更新结果
//    right += 1 # 移动右指针，去探索新的区间
//    return res

}
