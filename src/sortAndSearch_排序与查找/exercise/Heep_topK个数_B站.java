package sortAndSearch_排序与查找.exercise;

import java.util.Arrays;

/** 求乱序数组中的前top K个最大数 / 或者是键盘输入n个数,输入-1结束,输出topk个数
 * 解题思路:
 *  1.堆排序与二叉堆: 创建一个topK的辅助数组,每次都用小顶堆选出最小值,
 *   只要有新数据大于这个最小值,替换,调整使新的最小值浮上来
 * 2. partition+二分: 分区,找到mid=topk后,若是需要排序,则输出排好序的前K位
 */
public class Heep_topK个数_B站 {
    static int[] topK(int[] arr){
        //top数组
        int[] top= Arrays.copyOfRange(arr,0,10);
        //堆化top数组
        minHeapMaker(top);
        //遍历比较最小值,小就替换掉,并且重新调整小顶堆
        for (int i = 10; i < arr.length; i++) {
            if (arr[i]>top[0])
                top[0]=arr[i];
            minHeapFixdown(top,0);
        }
        return top;
    }

    public static void minHeapMaker(int[] arr){
        //从倒数第二层,一层层地向上调整顶堆
        for (int x=arr.length/2-1; x>=0;x--){
            minHeapFixdown(arr, x);
        }
    }

    /*知道父节点i求子节点:2i+1,2i+2 */
    static void minHeapFixdown(int[] arr,int father){
        int left=father*2+1;
        int right=father*+2;
        int minOfKid;
        //左结点过节
        if (left>arr.length-1)
            return;
        //右节点越界
        minOfKid=left; //找到小的子节点,这是种节约辅助空间的写法,不用temp了
        if (right>arr.length-1)
            minOfKid=left;
        else if (arr[left]>arr[right])
            minOfKid=right;

        //比较,若比最小子节点还小,交换,向下调整替换了的子树
        if (arr[father]>arr[minOfKid]){
            int temp=arr[minOfKid];
            arr[minOfKid]=arr[father];
            arr[father]=temp;
            minHeapFixdown(arr,minOfKid);
        }
        else return;
    }

    public static void main(String[] args) {
        int[] arg ={-1513,2,3,7,5,6,-12,4,3,9,110,-2,-1,-2,-7};
        int[] temp=topK(arg);
        System.out.println(Arrays.toString(temp));

        int[] arg02=new int[20];
        for (int i = 0; i < arg.length; i++) {
            arg02[i]=(int)(Math.random()*50);
        }
        System.out.println(Arrays.toString(topK(arg02)));
    }
}
