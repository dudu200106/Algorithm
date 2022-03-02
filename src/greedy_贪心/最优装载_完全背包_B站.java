package greedy_贪心;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给出n个物体，第i个物体重量为wi。选择尽量多的物体，使得总重量不超过C。
 */

public class 最优装载_完全背包_B站 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        int capacity = sc.nextInt();

        Arrays.sort(w);
        int ans = greedy(n, w, capacity);
        System.out.println(ans);
    }

    public static int greedy(int n, int[] w, int cap){
        int cnt=0;
        int amt=0;
        for (int i = 0; i < n; i++) {
            if (amt+w[i]<=cap){
                amt+=w[i];
                cnt++;
            }
            else break;
        }
        return cnt;
    }
}
