package sortAndSearch_排序与查找;

import java.util.Arrays;

/*原理: 类似撞车，左边的“小车”和右边的“大车”相向而来，之间的距离就是未排好的数值，
  大于参考主元pivot(参考数)的就丢到大车这边, 小于的就丢到小车这边,
  辆车开过了,交叉的时候就代表排序结束, 交换跑到小的这边的arr[right], 并把right当中间数的下标传出去。
  */

/**
 * 这里用问题“逐步生成”的思想，功能分作了两部分、两个方法：
 * 1. partition: 分割成两栏, 左小右大, 返回一个下标给quick_sort方法做中位数. 分割成一边大一边小、再返回主元pivot(中间数)下标的;
 * 2. quick_sort: 拆分, 递归向下拆分数组至只剩两个, 递归后向上回溯合并,变得有序;
 * (每次都分割时都调整为左小右大,当向下细分到只有两个时, 全部就排好了)
 */
public class QuickSort {
    public static void quick_sort(int[] arr, int prior, int row){
        if(prior<row) { //结束条件：prior==row，自然结束
            int mid = partition03(arr, prior, row);
            if (prior<mid)
                quick_sort(arr, prior, mid-1 );
            if (row>mid)
                quick_sort(arr, mid + 1, row); //这里的递归不用出栈（回溯）
        }
    }

    /*
      单项扫描(只有一边主动)的解法——索引0为主元，定义一个未扫描数据的最左边界指针left、最右边界值指针right，
      只有最左边界指针在扫描、在动，
      遇到大于主元的值全都丢到右边，left指针和right指针此时指向的值交换，
      left不动继续比较，右边界指针right前进一位。
      */
    private static int partition01(int[] arr, int prior, int row) {
        int pivot=arr[prior]; //定义一个参考的主元
        int left=prior+1; //定义一个未扫描数据的最左边界指针
        int right=row; //最右边界指针
        while(left<=right) { // 当二指针重合时,其实单项扫描工作已经完成了，之后right交错指向了一个小于主元pivot的值
            if (arr[left] <= pivot)
                left++;
            else {
                util.util.swap(arr,left,right); //注意，这里的left与right是指针，交换的是指向的值
                right--;
            }
        }
        util.util.swap(arr,prior,right); //right与left交错指向了一个小于pivot值，可以随意与主元pivot交换
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

    /*//双向扫描简化版本，避免每次都是最坏情况O(n平方), 参考的主元最好是中位数*/
    public static int partition03(int[] arr, int prior, int row){
        // 参考的主元,用三点比较求中位数
        int midIndex=(prior+row)/2;
        if (arr[prior]>arr[midIndex]&&arr[prior]<arr[row])
            midIndex=prior;
        if (arr[row]>arr[midIndex]&&arr[row]<arr[prior])
            midIndex=row;
        // 和第一个元素交换, 这样就又变成了熟悉的样子
        util.util.swap(arr,prior,midIndex);
        int pivot=arr[prior];
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
            arg[i]=(int)(Math.random()*20);
        }
        quick_sort(arg,0,arg.length-1);
        System.out.println(Arrays.toString(arg));
    }
}
