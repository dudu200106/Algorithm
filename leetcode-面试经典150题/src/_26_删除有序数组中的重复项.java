import java.util.TreeSet;

public class _26_删除有序数组中的重复项 {

    public int removeDuplicates(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int a: nums){
            set.add(a);
        }
        int i = 0;
        for (int num: set){
            nums[i++] = num;
        }
        return i;
    }

}
