package sortAndSearch_排序与查找.exercise;

/*问题描述: 一个数组,要求调整数组,奇数都在左边,偶数在右边*/

import util.ArrayUtil;

import java.util.Arrays;

//题目没说是否排序,故省略快速排序中递归排序的部分
public class Quick_前奇后偶_洛A {
    public static void sort_Partition(int[] arr, int prior, int row){
        int left=prior;
        int right=row-1;
        while (left<=right) {
            while (left<=right&&arr[left] % 2 >0)
                left++;
            while (left<=right&&arr[right] % 2 == 0)
                right--;
            if (left<right) //预防越界
                ArrayUtil.swap(arr, left, right);
        }
    }

    public static void swap(int[] arr,int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    public static void main(String[] args) {
        int[] arg=new int[8];
        for (int i = 0; i < arg.length; i++) {
            arg[i]=(int)(Math.random()*20);
        }
        sort_Partition(arg,0,arg.length);
        System.out.println(Arrays.toString(arg));
    }
}
