package dfs_深度优先搜索;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入正整数n，对1-n进行排列，使得相邻两个数之和均为素数，
 * 输出时从整数1开始，逆时针排列。同一个环应恰好输出一次。
 * n<=16
 *
 * 如输入：6
 * 输出：
 * 1 4 3 2 5 6
 * 1 6 5 2 3 4
 *
 * 思路:类似全排列, 但要加上剪枝和回溯(可以数值转下标used[],标记是否使用过)
 */
public class 素数环 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] use=new int[n+1];
        int[] r=new int[n];
        r[0]=1;
        dfs(n,use,r,1);
    }

    static void dfs(int n, int[] used, int[] res, int cur){
        if (cur>=n&&check(res[n-1]+1)){
            System.out.println(Arrays.toString(res));
            return ;
        }

        for (int i = 2; i <= n; i++) {
            if (check(res[cur-1]+i)&&used[i]==0) {
                res[cur]=i;
                used[i]=1;
                dfs(n,used,res,cur+1);
                used[i]=0;//回溯
            }
        }
    }

    static boolean check(int num){

        for (int i = 2; i*i <= num; i++) {
            if (num%i==0) return false;
        }
        return true;
    }
}
