public class _55_跳跃游戏 {


    /**
     * 我想到的第一个做法:  暴力递归+dp数组降低时间复杂度
     *      但还是超时了...
     *      官方答案是使用 贪心, 维护一个最远可达长度
     */
    public static int[] dp ;
    public boolean canJump01(int[] nums) {
        dp = new int[nums.length];
        return solve(nums, 0);
    }
    public boolean solve(int[] arr, int ind){
        if (ind>=arr.length-1)
            return true;
        if (dp[ind]!=0){
            return dp[ind]==1 ? true : false;
        }

        int val = arr[ind];
        boolean flag = false;
        for (int i = 1; i <=val ; i++) {
            flag = solve(arr, ind+i ) || flag;
        }
        dp[ind] = flag ? 1 : -1;
        return flag;
    }


    /**
     * 贪心  维护一个最长可达距离
     *
     *      对于任意一个起点, 我们可到达的最远距离是:
     *         mostLongDistance = max( x+1, x+2, ..., x+nums[x] ) , x< mostLongDistance
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int mostLong = 0;
        for (int i = 0; i < n; i++) {
            if (i<= mostLong){
                mostLong = Math.max( mostLong, i + nums[i]);
                if (mostLong >= n-1){
                    return true;
                }
            }else{ // 超出了, 也可以直接返回false
                break;
            }
        }
        return false;
    }

}
