package sortAndSearch_排序与查找;

import util.ArrayUtil;

import java.util.Arrays;

public class CountSort {
    public static void countSort(int[] arr){
        //找到最大值最小值
        int max= ArrayUtil.findMax(arr);
        int min= ArrayUtil.findMin(arr);

        //数值转下标, helper的值是arr的值,建立helper[max+1-min+1]辅助数组, 记录出现的次数
        int[] helper= new int[max-min+1];
        //会有负值,正值,  计数时下标arr[i]减去再-min; 0下标不要
        for (int i = 0; i < arr.length; i++) {
            helper[arr[i]-min]++;
        }
        //下标转数值, help[]遍历覆盖原数组
        int index=0; //arr的下标
        for (int h = 0; h < helper.length; h++) {
            while (helper[h]>0 && h < helper.length){ //是while不是if!! 忘记了!!!
                arr[index]=h+min; //注意这里,加减改变了
                index++;
                helper[h]--; //防止有重复
            }
        }

    }

    public static void main(String[] args) {
        int[] arg={-123,0,-2,54,23,5454};
        System.out.println(Arrays.toString(arg));
        countSort(arg);
        System.out.println(Arrays.toString(arg));
    }
}
