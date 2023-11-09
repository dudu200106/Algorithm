import java.util.Arrays;
import java.util.Comparator;

public class _435_无重叠区间 {
    /**
     最标准的解法是贪心, 当然也可以用动态规划的思想解决
     */

    /**
     * 这是用贪心的思想解决的:
     *      猜想区间越晚越好, 只要一个区间的左端点不与上一个区间重合, 选择右端点最小的区间, 就是当前以及全局最优解
     *
     *  此处根据区间的结束时间/右端点进行生序排列/由小到大;
     *  排序完的区间, 用一个变量记录 right 当前结果区间集合的最晚结束时间/最右端点,
     *  遍历排序区间, 只要当前区间的开始时间/左端点大于 right, 那就可以把当前区间加入结果集, 更新结束时间/最右端点
     * @param intervals
     * @return
     */
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2){
                return interval1[1] - interval2[1];
            }
        });

        int n = intervals.length;
        int right = intervals[0][1];
        int cnt = 1;
        for(int i=1; i < n; i++){
            if(intervals[i][0] >= right){
                right = intervals[i][1];
                cnt++;
            }
        }
        return n-cnt;
    }
}
