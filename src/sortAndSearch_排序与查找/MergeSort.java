package sortAndSearch_排序与查找;

import java.util.Arrays;

/**
 * 1. merge: 将前后相邻的有序表合并为一个有序表,创建辅助盘,不断找出左右两个有序表中最小的值,
 *      决定谁先入栈(因为这个方法需要左右分别都有序)
 * 2. merge_sort: 拆分数组, 再递归向下拆分两个子数组(结束递推后,merge方法合并出栈回来的两个子数组)
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
        while(left<=mid && right<=high){
            if (helper[left]<=helper[right])
                arr[current++] = helper[left++];
            else
                arr[current++] = helper[right++];
        }
        //3. 相邻有序表的必有某个表元素先全部入栈，剩下的另一个表中元素单独入栈
        while(left<=mid) //前一个有序表单独入栈
            arr[current++]=helper[left++];
        //若是后一个有序表剩下了,刚好对应原数组中的大小顺序位置,可以省略单独入栈过程 (辅助盘拷贝原数组,右边剩下有序数字的就是最大的几个)
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
