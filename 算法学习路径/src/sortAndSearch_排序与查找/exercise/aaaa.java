package sortAndSearch_排序与查找.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class aaaa {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int size=input.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i]= input.nextInt();
        }

        int times=input.nextInt();

        for (int i = 0; i < times; i++) {
            int l=input.nextInt();
            int r=input.nextInt();
            int K=input.nextInt();
            int[] temp=Arrays.copyOfRange(arr,l-1,r);
            Arrays.sort(temp);
            System.out.println(temp[temp.length-K]);
        }
    }
}
