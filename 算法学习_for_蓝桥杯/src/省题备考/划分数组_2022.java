package 省题备考;

import java.util.Arrays;
import java.util.Scanner;

public class 划分数组_2022 {
    static int[] arr =new int[10000];

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int N= sc.nextInt();
        for (int i = 0; i < N; i++) {
            arr[i]=sc.nextInt();
        }
        int[] dp =new int[10005];

    }

    /**
     * */


    static boolean check(int start, int end){
        int len=end - start;
        int[] help =new int[10005];
        int min=Integer.MAX_VALUE;
        for (int i = start; i <end ; i++) {
                min=Math.min(min,arr[i]);
                help[arr[i]]=1;
        }
        for (int i = min; i<min+len; i++) {
            if (help[i] == 0)
                return false;
        }
        return true;
    }
}
