import java.util.HashMap;
import java.util.Map;

class _560_和为k的子数组 {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map =new HashMap<Integer, Integer>();
        int[] preSum = new int[nums.length+1];
        map.put(0,1); //初始化哈希表--subarraySum(0,3) =preSum[3] - preSum[0];
        int res=0;
        for (int i = 1; i < nums.length+1; i++) {
            preSum[i] = nums[i-1] +preSum[i-1];
            int num_1=preSum[i];
            int num_2= num_1 -k;
            if (map.containsKey(num_2))
                res += map.get(num_2);

            map.put(num_1, map.getOrDefault(num_1,0) + 1);
        }
        return res;
    }
}
