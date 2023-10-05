package sortAndSearch_排序与查找.exercise;

import java.util.Arrays;

/**从左往右输出数组中,需要排序的子数组
 * 解法:在一段数组中,它可能需要排序的子数组是有左右边界的,
 *    故分两次遍历(从左往右,从右往左),分别查找左右边界值;
 *    而如何确定边界值,则可以画一个折线图,发现与其"驻点值"有关.
 * 步骤: step1:创建左右边界指针,历史最高/低峰值
 *      step2:寻找历史最高峰值,并更新右边界值;
 *      step3:寻找历史最低峰值,并更新左边界值;
 *      step4:结束,输出子数组
 */
public class 需要排列数组长度_B站 {
    static int[] needSortArr(int[] arr){
        //定义两个边界指针
        int left=arr.length-1;
        int right=0;
        //定义最大/小峰值
        int maxPeek=-1000001;
        int minPeek=1000001;
        //遍历扫描,更新历史最高峰值和右边界值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]<arr[i-1]&&arr[i-1]>maxPeek) {
                maxPeek = arr[i - 1];
            }
            if (arr[i]<=maxPeek) {
                right=i;
            }
        }
        //遍历扫描,更新历史最低峰值和左边界值
        for (int j = arr.length-1; j >0; j--) {
            if (arr[j]<arr[j-1]&&arr[j-1]<minPeek) {
                minPeek = arr[j - 1];
            }
            if (arr[j]>=minPeek) {
                left=j;
            }
        }
        if (left==arr.length-1&&right==0)
            return new int[]{0, 0};
        else
            return Arrays.copyOfRange(arr,left,right+1);//左闭右开
    }

    public static void main(String[] args) {
        int[] arg ={1,2,3,7,5,6,8,4,3,9,10};
        System.out.println(Arrays.toString(needSortArr(arg)));
    }
}
