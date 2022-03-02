package sortAndSearch_排序与查找;

import java.util.Arrays;

public class BubbleSort {
    static void bubble_Sort(int[] a){
        int temp;
        for (int i=0; i<a.length; i++)
            for (int j = 0; j < a.length-i-1; j++) {
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
