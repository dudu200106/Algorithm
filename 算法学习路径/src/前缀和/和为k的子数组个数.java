package 前缀和;

import java.util.HashMap;

public class 和为k的子数组个数 {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int cnt = 0;
        int prefix_sum = 0;
        for (int num : nums){
            prefix_sum += num;
            int cha = prefix_sum - k;
            if (map.get(cha)!= null){
                cnt += map.get(cha);
            }
            if (map.get(prefix_sum) == null){
                map.put(prefix_sum,1);
            }else {
                map.put(prefix_sum,map.get(prefix_sum)+1);
            }
        }

        return cnt;
    }
}
