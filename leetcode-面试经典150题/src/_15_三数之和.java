import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _15_三数之和 {

    /**
     * 双指针 + 排序去重
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int first = 0; first < len-2; first++) {
            if (first>0 && nums[first]==nums[first-1])
                continue;
            int diff = -nums[first];
            int left= first+1, right = nums.length-1;
            int ans = 0;
            while (left<right){
                if (nums[left]+nums[right] < diff  ||
                        left > first + 1 && nums[left] == nums[left-1]){
                    left++;
                }else if (nums[left]+nums[right] > diff){
                    right--;
                }else  {
                    List<Integer> curlist = new ArrayList<>();
                    curlist.add(nums[first]);
                    curlist.add(nums[left]);
                    curlist.add(nums[right]);
                    list.add(curlist);
                    left++;
                    right--;
                }
            }
        }
        return list;
    }
}
