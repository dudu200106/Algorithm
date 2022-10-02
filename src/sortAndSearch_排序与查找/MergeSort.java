package sortAndSearch_排序与查找;

import java.util.Arrays;

/**
 * 1. merge: 合并左右有序数组, 创建辅助盘,不断比较左右两边最小的值,决定谁先入栈(因为这个方法需要左右分别都有序)
 * 2. merge_sort: 拆分数组, 再递归向下拆分两个子数组; 结束递推,合并回溯回来的两个子数组
 */
public class MergeSort {
    // merge_sort的实现过程是自顶向下又自底向上的(分治压入栈后又合并出栈)
    public static void merge_sort(int[] arr,int left,int right){
        //1. 退出条件,特性解：只剩下了一个数不用排了
        if (left<right){
            int mid=(left+right)/2; //2. 划分左右栏, 再分治
            merge_sort(arr,left,mid);
            merge_sort(arr,mid+1,right);
            merge(arr,left,mid,right); //3. 出栈自底向上,融合数组
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        //1. 深拷贝创建一个辅助数组，已排序好的左右两栏，比较左右最小值，较小的数据先覆盖原数组
        int[] helper= Arrays.copyOfRange(arr,0,arr.length); //区间左闭右开

        int current=low; //原数组栈顶指针
        int left=low; //左边最小的首指针
        int right=mid+1;
        //2. 比较左右栏的最小值谁先入栈
        while(left<=mid&&right<=high){
            if (helper[left]<=helper[right]) {
                arr[current] = helper[left];
                left++;
                current++;
            }else {
                arr[current] = helper[right];
                right++;
                current++;
            }
        }
        //3. 若某一边数值先入栈完时，右栏倒是不用处理了(辅助盘拷贝原数组,剩下的几个大数字的位置-->||刚好是一样的)，左边就得单独入栈
        while(left<=mid)
            arr[current++]=helper[left++];

    }

    public static void main(String[] args) {
        int[] arg=new int[10];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*101);
        }
        merge_sort(arg,0,arg.length-1);
        System.out.println(Arrays.toString(arg));

    }
}
