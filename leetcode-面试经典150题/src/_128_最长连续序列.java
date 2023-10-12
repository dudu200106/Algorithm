import java.util.HashSet;

public class _128_最长连续序列 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int max_seq = 0;
        for (int num: nums){
            set.add(num);
        }

        for (int num: nums){
            if (!set.contains(num-1)){
                int cur_cnt = 1;
                while(set.contains(++num)){
                    cur_cnt++;
                }
                max_seq = Math.max(max_seq, cur_cnt);
            }
        }
        return max_seq;
    }
}
