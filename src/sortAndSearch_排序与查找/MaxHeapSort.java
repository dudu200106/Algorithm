package sortAndSearch_排序与查找;

import java.util.Arrays;

/**
 * 堆排序步骤:
 * 1.纵向有序: 数组堆化,变成二叉堆
 * 2.横向有序: 排序,每次都调换根节点和未排序范围内最后一个叶子结点(数组的首和尾),大小顶堆转换,数组变得有序
 */
public class MaxHeapSort {

    //step0:  maxHeapFixdown,某节点的大/小顶堆调整方法(这里是大顶堆),基础
    public static void maxHeapFixdown(int[] arr, int index, int range){ //range控制树的数量大小
        //找到子树根节点俩子节点
        int left = 2*index+1;
        int right = 2*index+2;

        //1.判断子节点是否越界,结束条件; 2.找到最大子节点;
        int max;
        if (left>=range)
            return;
        if (right>=range)
            max=left;
        else{
            if (arr[left]>arr[right]){
                max=left;
            }else
                max=right;
        }
        //父节点比较是否交换
        if (arr[max]<=arr[index])
            return;
        //若是交换,则递归向下调整交换子节点子树
        int temp=arr[index];
        arr[index]=arr[max];
        arr[max]=temp;
        maxHeapFixdown(arr,max,range);
    }

    /*step1: maxHeapMaker,堆化数组(这里是大顶堆),使得二叉堆成立(纵向有序,横向待定)*/
    public static void maxHeapMaker(int[] arr){

        //从倒数第二层,一层层地向上调整顶堆
        for (int x=arr.length/2-1; x>=0;x--){
            maxHeapFixdown(arr, x,arr.length);
        }
    }

    /*step2: maxHeapSort,反转二叉堆(大顶堆<->小顶堆),使得"物理数组"有序*/
    public static void maxHeapSort(int[] arr){

        //堆化数组
        maxHeapMaker(arr);
        //对换二叉堆根节点与最后未排序的节点(根节点是最大值/最小值,相当于将最大/小值顶到数组末尾)
        for (int i=arr.length-1; i>0; i--){
            util.util.swap(arr,i,0);
            maxHeapFixdown(arr,0,i-1);
        }
        //缩小树范围,并调整新根节点的二叉堆(这样不断调换,不断缩小二叉堆,不断向下调整新二叉堆,最终大小顶堆调换,)
    }

    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*20);
        }

        maxHeapSort(arg);
        System.out.println(Arrays.toString(arg));
    }
}
