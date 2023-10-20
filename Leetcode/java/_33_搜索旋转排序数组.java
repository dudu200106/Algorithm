public class _33_搜索旋转排序数组 {

    /**
     * 这一题出现了一个“二段性” —— 数组分做了两段，一段大于等于首元素nums[0], 另一段小于nums[0];
     * 故我们可以找到中间断开的点, 并选择在哪一段进行二分
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        if (nums.length==0) return -1;

        int interrupt = findInterrupt(nums);
        int r=-1, l=-1;
        // 判断target是在在哪一段，对其进行二分
        if (nums[0]>target||nums[0]==nums[interrupt]){
            l=interrupt;
            r= nums.length-1;
        }else {
            l=0;
            r=interrupt;
        }
        while(l<r){
            int mid = (l+r)>>1;
            if (nums[mid]>=target){
//                if (nums[mid] == target) //刚好中点命中的几率很低, 故不加这一段对整体时间复杂度的影响不大
//                    return mid;
                r=mid;
            }else {
                l=mid+1;
            }
        }
        // 用模版实现二分的话, 注意判断数组中不存在目标值的情况
        return nums[r]==target ? r : -1;

    }

    public int findInterrupt(int[] nums){
        int l=0, r=nums.length-1;
        int first = nums[0];
        while (l<r){
            int mid = (l+r)>>1;
            if (nums[mid]<first){ // 这里是寻找断点的关键, 如果有断点一定处于最左元素之后
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return r;
    }
}
