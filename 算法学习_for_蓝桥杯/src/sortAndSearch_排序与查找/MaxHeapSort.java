package sortAndSearch_排序与查找;

import java.util.Arrays;

/**
 * 堆排序步骤:
 * 1.纵向有序: 数组堆化,变成二叉堆
 * 2.横向有序: 排序,每次都调换根节点和未排序范围内最后一个叶子结点(数组的首和尾),大小顶堆转换,数组变得有序
 */

/**
 注:因为headAdjust堆调整算法,默认只有根节点的值破坏了堆的结构, 根节点之下的元素满足大顶堆定义的,
 故只需将根节点的值放到合适的位置就行 (有点类似选择排序)
 */
public class MaxHeapSort {

    //step0: heapAdjust, 根节点的值破坏了堆的结构, 把根节点的值向下调整至合适的位置 (大顶堆,基础,递归版本)
    public static void heapAdjust(int[] arr, int root, int len){ //range控制树的数量大小
        //1.先判断子节点是否越界; 找到最大值孩子结点的下标;
        int i= root*2;
        if (i>=len) return; // 叶结点,退出递归
        if (i+1 <len && arr[i]<arr[i+1]) i++; //找出俩孩子结点最大值下标
        //2.子节点的值是否比父节点的值大
        if (arr[i]<=arr[root])
            return;
        //交换父子结点的值
        util.util.swap(arr, root, i);
        //继续递归向下调整新形成的子树
        heapAdjust(arr,i,len);
    }


    // heapAdjust调整算法的迭代版本, 类似选择排序
    public  static void heapAdjust01(int[] arr, int k, int len){
        int temp = arr[k]; //保存根节点值, 变量k之后存放空结点下标
        for (int i = k*2; i < len; i*=2) { //自增二倍,一直往下,知道找到
            if (i+1<len && arr[i]<arr[i+1])
                i++;
            if (arr[i]<=temp) break; //找到了原根节点值合适的位置,退出
            arr[k] = arr[i];
            k=i;
        }
        arr[k]=temp; //原root的值放到合适的位置

    }

    /*step1: buildMaxHeap,堆化数组(这里是大顶堆),构造初始堆(使纵向有序,横向待定)*/
    public static void buildMaxHeap(int[] arr,int len){
        //从倒数第二层,一层层地向上调整顶堆
        for (int index=(len-1)>>1; index>=0; index--){
            heapAdjust01(arr, index, len);
        }
    }

    /*step2: maxHeapSort,反转二叉堆(大顶堆<->小顶堆),使得"物理数组"有序*/
    public static void maxHeapSort(int[] arr,int len){
        //堆化数组
        buildMaxHeap(arr,len);
        //对换二叉堆根节点与最后未排序的节点(根节点是最大值/最小值,相当于将最大/小值顶到数组末尾)
        for (int i=len; i>0; i--){
            util.util.swap(arr,i-1,0); //交换最后一个叶结点(堆底,数组尾部元素)
            heapAdjust01(arr,0, i-1); //堆的大小减一
        }
        //缩小树范围,并调整新根节点的二叉堆(这样不断调换,不断缩小二叉堆,不断向下调整新二叉堆,最终大小顶堆调换,)
    }

    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*101);
        }

        maxHeapSort(arg,8);
        System.out.println(Arrays.toString(arg));
    }
}
