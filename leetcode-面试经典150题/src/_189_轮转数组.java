/**
 *
 */
public class _189_轮转数组 {

    /**
     * 数组轮转
     *      翻转三次数组, 最后得到答案, 详情直接看代码,
     *      实现时间复杂度o(n), 空间复杂度O(1)的
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n-1); // 第一次翻转, 全部翻转
        reverse(nums, 0, k-1); // 第二次翻转, 前k%n 个翻转
        reverse(nums, k, n-1); // 第三次翻转, 剩余元素翻转 (总的翻转了2n次)
    }

    public void reverse(int[] nums, int start, int end){
        while (start<end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }

}
