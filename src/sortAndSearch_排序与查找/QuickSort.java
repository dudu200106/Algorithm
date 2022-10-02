package sortAndSearch_排序与查找;

import java.util.Arrays;


/**
 * 这里用问题“逐步生成”的思想，功能分作了两部分、两个方法：
 * 1. partition: 使原数组分割成两栏, 左小于pivot(枢轴),右大于pivot;
 *      最后返回pivot最后的位置, 给quick_sort方法做中位数, 分治递归排序;
 * 2. quick_sort: 拆分, 递归向下拆分数组至只剩两个, 递归后向上出栈合并,变得有序;
 * (每次都分割时都调整为左小右大,当向下细分到只有两个时, 全部就排好了)
 */
public class QuickSort {
    public static void quick_sort(int[] arr, int low, int high){
        if(low<high) { //结束条件：low==high，递归到只有一个数值的特殊情况停下
            int indexOfPivot = partition03(arr, low, high);
                quick_sort(arr, low, indexOfPivot-1 );
                quick_sort(arr, indexOfPivot + 1, high); //这里的递归不用出栈（回溯），实现过程自上而下
        }
    }

    /**
     * 最好用的双向扫描的简化版本--来自严蔚敏版本, 更清晰易懂
     * 这个版本好在把枢轴提出来保存起来了, 使得原数组空了一位, 方便交换
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int partition01_1(int[] arr, int low, int high) {
        int pivot = arr[low]; //保存枢轴, 随后首先找一个小于pivot的数覆盖他的位置
        while (low<high){
            while (low<high && arr[high]>pivot)
                high--;
            arr[low] = arr[high];
            while (low<high && arr[low]<pivot)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

    /** 双向扫描优化版本，避免每次都是最坏情况时间复杂度:O(n^2), 参考的主元枢轴最好是中位数
     *      有两种主要的方法
     * */
    public static int partition03(int[] arr, int low, int high){
        // 参考的主元,用三点比较求中位数
        int midIndex=(low+high)/2;
        if (arr[low]>arr[midIndex]&&arr[low]<arr[high])
            midIndex=low;
        if (arr[high]>arr[midIndex]&&arr[high]<arr[low])
            midIndex=high;
        // 和第一个元素交换, 这样就又变成了熟悉的样子
        util.util.swap(arr,low,midIndex);
        int pivot = arr[low];
        while(low<high) {
            //得考虑极端边界情况，如果主元pivot恰好最大/最小，边界值指针会冲出去越界
            while (low<high && arr[high]>pivot) high--;
            arr[low] = arr[high];
            while (low<high && arr[low]<pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low; //pivot的位置
    }

    /** (细节也不好理解)
      单项扫描(只有一边主动)的解法——索引0为主元，定义一个未扫描数据的最左边界指针left、最右边界值指针right，
      只有最左边界指针在扫描、在动，
      遇到大于主元的值全都丢到右边，left指针和right指针此时指向的值交换，
      left不动继续比较，右边界指针right前进一位。
      */
    public static int partition01(int[] arr, int low, int high) {
        int pivot=arr[low]; //定义一个参考的主元
        int left=low+1; //定义一个未扫描数据的最左边界指针
        int right=high; //最右边界指针
        while(left<=right) { // 当二指针重合时,其实单项扫描工作已经完成了，之后right交错指向了一个小于主元pivot的值
            if (arr[left] <= pivot)
                left++;
            else {
                util.util.swap(arr,left,right); //注意，这里的left与right是指针，交换的是指向的值
                right--;
            }
        }
        util.util.swap(arr,low,right); //right与left交错指向了一个小于pivot值，可以随意与主元pivot交换
        return right;//right此时就成了中位数
    }


    /*双向扫描的思路是:
    头尾指针往中间扫描，从左找到大于主元的元素，从右找到小于等于主元的元素二者交换，
    继续扫描，直到左侧无大元素，右侧无小元素*/
    public static int partition02(int[] arr, int prior, int row){
        int pivot=arr[prior]; //定义一个参考的主元
        int left=prior+1;
        int right=row;
        while(left<=right) { // 指针交错，停止迭代
            //得考虑极端边界情况，如果主元pivot恰好最大/最小，边界值指针会冲出去越界
            while (left<=right && arr[left]<=pivot) left++;
            while (left<=right && arr[right]>=pivot) right--;
            if(left<right) //防止越界. while的最后一个条件不满足循环条件跳出，肯定过界了，不能交换
                util.util.swap(arr,left,right);
        }
        util.util.swap(arr,right,prior);
        return right;//中位数
    }



    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*101);
        }
        quick_sort(arg,0,arg.length-1);
        System.out.println(Arrays.toString(arg));

    }
}
