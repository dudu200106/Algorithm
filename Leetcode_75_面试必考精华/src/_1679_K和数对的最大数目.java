import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1679_K和数对的最大数目 {

    /**
     * 借助哈希表实现的一种方法
     * @param nums
     * @param k
     * @return
     */
    public int maxOperations(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for (int i = 0; i < nums.length; i++) {
            int diff = k-nums[i];
            if (map.containsKey(diff)){
                if (diff == nums[i]){
                    ans += map.get(nums[i])/2;
                    map.remove(nums[i]);
                    continue;
                }
                ans+=Math.min(map.get(nums[i]), map.get(diff));
                map.remove(diff);
                map.remove(nums[i]);
            }
        }
        return ans;
    }

    /**
     * 双指针 实现的方法
     *    -- 注: 这题规定了"每次选两个元素的和等于k", 若是多余两个以上的元素,则双指针方法不适用
     */
    public int maxOperations_2(int[] nums, int k) {
        Arrays.sort(nums);
        int left= 0, right = nums.length-1;
        int ans = 0;
        while (left<right){
            if (nums[left]+nums[right] > k){
                right--;
            }else if (nums[left]+nums[right] < k){
                left++;
            }else {
                ans++;
                left++;
                right--;
            }
        }
//        if(left==right && nums[left] == k)
//            ans++;
        return ans;
    }
}
