package sortAndSearch_排序与查找;

import java.util.Arrays;

/**
 *
 * 思想就是：每次选出最小/最大的值。。。直到只剩一个，排序完成
 *          (像冒泡泡一样, 最小的泡泡不断"漂浮"到"水面")
 *          步骤就是不断交换逆序对, 让最大/小的值移动到最边边上
 */
public class BubbleSort {
    static void bubble_Sort(int[] a){
        int temp;
        for (int i=0; i<a.length; i++)
            for (int j = 0; j+1 < a.length-i; j++) {
                if (a[j]>a[j+1]){
                    temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
    }

    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*20);
        }
        bubble_Sort(arg);
        System.out.println(Arrays.toString(arg));
    }
}
