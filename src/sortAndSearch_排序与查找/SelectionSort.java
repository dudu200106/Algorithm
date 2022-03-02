package sortAndSearch_排序与查找;

import util.util;
import java.util.Arrays;

public class SelectionSort {
    public static void selection_Sort(int[] a){
        for (int i = a.length-1; i>0 ; i--) {
            int indexMax=0; //相比冒泡不用每次都交换，只是最后把找出来的最大值和天花板值交换
            int max=a[0];

            for (int j = 0; j <=i; j++) { //找出第n大的值（n=1,2,3。。。）
                if (a[j]>max){
                    indexMax=j;
                    max=a[j];
                }
            }
            util.swap(a,indexMax,i); //交换，只交换了一次
        }
    }

    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*20);
        }
        selection_Sort(arg);
        System.out.println(Arrays.toString(arg));
    }
}
