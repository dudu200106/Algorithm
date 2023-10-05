package sortAndSearch_排序与查找.exercise;

import java.util.Scanner;

/*计数排序,数值转下标*/
public class count_明明的随机数_洛谷 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int size=input.nextInt();
        int[] arr=new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]=input.nextInt();
        }

        int num=sort(arr);
        System.out.println(num);
        for (int i = 0; i <num ; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static int sort(int[] arr){
        int max=-10001;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]>max) max=arr[i];
        }
        int[] helper=new int[max+1]; //数值转下标,0不要

        for (int j = 0; j < arr.length; j++) {
            helper[arr[j]]++;
        }
        int index=0;
        int count=0;
        for (int k = 1; k < helper.length; k++) {
            if (helper[k]>0){
                arr[index]=k;
                index++;
                count++;
            }
        }
        return count;
    }
}
