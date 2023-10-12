public class _238_除自身以外数组的乘积 {

    /**
     * 本题目, 要求不能用除法, 且时间复杂度为O(n);
     *      那么考虑添加两个预处理的数组-- 前缀乘积数组和后缀乘积数组,
     *      answer[i] = preMuti[i-1] + sufMuti[i+1]
      * @param nums 除本身元素以外的数组乘积数组
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[] preMuti = new int[len];
        int[] sufMuti = new int[len];
        preMuti[0]=nums[0];
        sufMuti[len-1]=nums[len-1];
        for (int i = 1; i < nums.length; i++) {
            preMuti[i] = nums[i] * preMuti[i-1];
            sufMuti[len-i-1] = sufMuti[len-i] * nums[len-i-1];
        }
        for (int i = 1; i < ans.length-1; i++) {
            ans[i] = preMuti[i-1]*sufMuti[i+1];
        }
        ans[0] = sufMuti[1];
        ans[len-1] = preMuti[len-2];
        return ans;
    }

    /**
     * 那如何将空间复杂度降低到O(1)呢?
     *      这可以在第一遍遍历时得到前缀乘积, 再逆向遍历一遍乘以后缀乘积
     *
     */

    public int[] productExceptSelf_2(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i-1] * nums[i-1];
        }
        int sufMuti = 1;
        for (int i = len-1; i >=0; i--) {
            ans[i] = ans[i] * sufMuti;
            sufMuti *= nums[i];
        }
        return ans;
    }
}
