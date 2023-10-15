public class _643_子数组最大平均数_I {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        for (int j = k; j <nums.length ; j++) {
             sum = Math.max(sum,sum + nums[j] - nums[j-k]);
        }
        return sum/k;
    }
}
