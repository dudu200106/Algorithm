package sortAndSearch_排序与查找;

import util.util;
import java.util.Arrays;

/**
 *
 * 思想：其实就是冒泡排序的改良版本。
 *      不用每次遇到最小/大值都交换，只是保存当前最大值的数值下标，只最后进行一次交换.
 */
public class SelectionSort {
    public static void selection_Sort(int[] arr){
        for (int i=0; i< arr.length ; i++) { //相当于"第i+1小"的值
            int indexMin=i; //相比冒泡不用每次都交换，保存了当前范围内的最大值的下标后,和天花板值(最右值)交换
            int j;
            for (j=i+1; j<arr.length; j++) { //找出第n大的值（n=1,2,3。。。）
                if (arr[j]<arr[indexMin]){
                    indexMin=j; //更换最小值元素下标
                }
            }
            if (indexMin != i)
            util.swap(arr,indexMin,i); //交换，只交换了一次
        }
    }

    public static void main(String[] args) {
        int[] arg=new int[10];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*101);
        }
        selection_Sort(arg);
        System.out.println(Arrays.toString(arg));
    }
}
