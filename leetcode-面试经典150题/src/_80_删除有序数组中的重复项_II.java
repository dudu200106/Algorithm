public class _80_删除有序数组中的重复项_II {

    /**
     * 要求空间复杂度为O(1), 那只能用双指针了
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int write = 0;
        int cur_num= Integer.MIN_VALUE;
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]!= cur_num){
                cur_num = nums[i];
                nums[write++]= cur_num;
                cnt = 1;
            }else if (cnt < 2){
                nums[write++]= cur_num;
                cnt++;
            }else{
                cnt++;
            }
        }
        return write;
    }

}
