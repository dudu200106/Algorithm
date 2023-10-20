public class _162_寻找峰值 {
    public int findPeakElement(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            flag = (i == 0 || nums[i] > nums[i - 1]);
            flag = (i == nums.length - 1 || nums[i] > nums[i + 1]);
            if (flag) {
                return i;
            }
        }
        return 0;
    }

    public int findPeakElement_2(int[] nums) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= nums[mid + 1]) {
                r = mid;
            } else {
                mid = mid + 1;
            }
        }
        return r;
    }
}
