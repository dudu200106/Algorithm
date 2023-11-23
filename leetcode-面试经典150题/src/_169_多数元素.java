import java.util.Arrays;

/**
 * 1.简单方法可以使用哈希表对出现的元素进行计数, 但是空间复杂度为O(n)
 * 2.排序可以很简单地解决空间复杂度为O(1)的要求, 但是时间复杂度升级为O(nlogn)
 * 3.官方和其他作者提供了另外一种思路: 摩尔人投票法
 *
 */
public class _169_多数元素 {

    /**
     * 排序法  直接返回排好序的中位数元素
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 投票法   多数元素的数量一定大于剩下的元素数量
     *    我们假设这是在投票:
     *      初始化第一位候选人 candidate = nums[0], 选票数 cnt = 1.
     *      如果下一票 等于 candidate, 则 cnt +1, 否则就 -1;
     *      当目前候选人 cnt==0时, 换候选人;
     *      最后的 candidate一定是
     * @param nums
     * @return
     */
    public int majorityElement02(int[] nums) {
        int candidate = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==candidate){
                cnt++;
            }else{
                cnt--;
            }
            if (cnt==0){ // 判断是否得更换候选人
                candidate = nums[i];
                cnt =1;
            }
        }
        return candidate;
    }


}
