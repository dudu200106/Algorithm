package greedy_贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 *
 * 给定 N 个加号、M 个减号以及 N + M + 1 个整数 A1,A2,··· ,AN+M+1，小 明想知道在所有由这 N 个加号、M 个减号以及 N + M +1 个整数凑出的合法的后缀表达式中，结果最大的是哪一个？
 * 请你输出这个最大的结果。
 * 例如使用1 2 3 + -，则 “2 3 + 1 -” 这个后缀表达式结果是 4，是最大的。
 *
 * 【输入格式】
 * 第一行包含两个整数 N 和 M。 第二行包含 N + M + 1 个整数 A1,A2,··· ,AN+M+1。
 *
 * 【输出格式】
 * 输出一个整数，代表答案。
 *
 * 【样例输入】
 * 1 1
 * 1 2 3
 *
 * 【样例输出】
 * 4
 */
public class 后缀表达式_省题 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int N=in.nextInt();
        int M=in.nextInt();
        int[] num= new int[N+M+1];
        for (int i = 0; i < N+M+1; i++) {
            num[i]=in.nextInt();
        }
        Arrays.sort(num);
        int res= solve(N,M,num);
        System.out.println(res);
    }

    static int solve(int n, int m, int[] num){
        int index=n+m;
        int res=num[index];
        index--;
        for (int i = 1; i <=n ; i++) {
            res+=num[index];
            index--;
        }
        for (int j = 1; j <=m ; j++) {
            res-=num[index];
            index--;
        }
        return res;
    }
}
