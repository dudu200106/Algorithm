import java.util.Arrays;
import java.util.Comparator;

public class _452_用最少数量的箭引爆气球 {
    /**
     * 区间最优, 还是要使用贪心.
     *  贪心的思想就是, 对区间按照右端点从小到大排序,
     *  1.假设使用最少的点/箭头就能触及所有区间, 每个点/箭头必定是在未被触及/射到的区间的最右边, 且得是排序最小的那个区间的右端点;
     *  2.我们记录当前的右端点为pnt, 按照从小到大顺序遍历, 找到下面第一个不被该右端点射到/触及到的区间, 将它的右端点作为下一个pnt, 点/箭头计数+1;
     *  重复步骤 2 直至遍历完整个排序后的数组
     * @param points
     * @return
     */

    public int findMinArrowShots(int[][] points) {
        if(points.length==0)
            return 0;

        Arrays.sort(points, new Comparator<int[]>() {
//            // 注意此处, 比较方法为什么不能这样, 这样最后一个用例不能通过--数据太大, int类型溢出了
//            public int compare(int[] o1, int[] o2) {
//                return o1[1]-o2[1];
//            }

            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1;
                } else if (point1[1] < point2[1]) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        int cnt = 1;
        int pnt = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0]>pnt){
                pnt = points[i][1];
                cnt++;
            }
        }
        return cnt;
    }
}
