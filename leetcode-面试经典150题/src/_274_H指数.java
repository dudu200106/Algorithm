import java.util.Arrays;
import java.util.HashSet;

public class _274_H指数 {

    /**
     * 用一个差分数组维护 论文被引用次数 大于等于下标值 的篇数
     *      -- 如: 有arr[3]=5, 5篇论文被引用次数大于等于 3;
     *      (但这个数组是个差分数组, 方便一次性修改整个区域的值)
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        // 这个差分数组下标代表 有 citations[i] 篇论文的被引用次数 大于等于 i
        int[] preCha = new int[1002];
        for (int i = 0; i < citations.length; i++) {
            int val= citations[i];
            preCha[1]--;
            preCha[val+1]++;
        }
        int curVal = 0;
        int res =0;
        // 遍历差分数组, 找出最大的引用h指数()
        for (int i = 1; i < 1002; i++) {
            curVal -= preCha[i];
            if (curVal >= i){
                res = Math.max(res, i);
            }
        }
        return res ;
    }


    /*
     * 下面我要使用官方给出的其他三种方法, 用来解决这个问题
     *      1. 排序法
     *      2. 计数排序
     *      3. 二分查找 (此处满足二异性-- h有上限1000.
     *          它是满足「有 h 篇论文的引用次数至少为 h」的最大值。
     *          小于等于 h 的所有值 x 都满足这个性质，而大于 h 的值都不满足这个性质。)
     */

    /**
     * 排序法   通过排序后有的顺序, 从大到小遍历满足 "被引用次数arr[i]>=i" 的元素个数,
     * @param citations
     * @return
     */
    public int hIndex02(int[] citations) {
        Arrays.sort(citations);
        int res =0;
        for (int i = 1; i <= citations.length; i++) { // 反序
            int val = citations[citations.length-i];
            if (val>= i){
                res =i;
            }
        }
        return res ;
    }

    /**
     * 计数排序
     * @param citations
     * @return
     */
    public int hIndex03(int[] citations) {
        Arrays.sort(citations);
        int res =0;
        for (int i = 1; i <= citations.length; i++) { // 反序
            int val = citations[citations.length-i];
            if (val>= i){
                res =i;
            }
        }
        return res ;
    }



}
