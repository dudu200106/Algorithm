/*
 * 描述
* 某国家一共有 n 座城市，有的城市与城市与城市之间有路相连，所有的路都是无向的，n 个城市可以通过道理相互达到，
* 其中 2k 座城市是重要城市，国王希望把这 2k 座城市两两配对，形成 k 对友好城市。
* 友好城市之间常常需要进行交流，因此国王希望友好城市之间的距离不要太长，
* 于是他定义两个城市 u，v 配对的代价为 u，v 之间最短路的长度，2k 座城市配对的总代价为 k 对城市配对的代价和。
* 国王想知道配对的最小代价。
数据范围：
2≤n≤100，1≤A[i][j]≤1000 或 A[i][j]=−1，A[i][j]=−1，1≤k≤8，2×k≤n
输入描述：
第一行输入一个数n ，表示城市个数。接下来输入一个n*n 的邻接矩阵A ，
* A[i][j] 表示城市 i 和 城市 j 之间边的长度，如果 A[i][j] = -1，表示 i 和 j 之间没有直接相连的边，
* 输入保证 A[i][j] = A[j][i] ，A[i][i] = -1 ，且 n 个城市相互连通。
*  最后输入一个数 k ，接下来一行 2k 个数，这 2k 个重要城市的编号
*
输出描述：
输出一个数，最小匹配代价
示例1
输入：
4
-1 2 -1 10
2 -1 3 -1
-1 3 -1 1
10 -1 1 -1
2
1 2 3 4

输出：
3
 */

import java.util.Scanner;

/**
 * 很明显, 1.这题既要求每个城市间的最小距离, 2.又要在所给的数组中两两配对, 求出配对距离最短
 *
 * 1：使用Floyd算法求出所有city间最短距离
 * 2：dfs遍历搜索两两配对距离和最短（注意和组合排序的区别）
 */
public class MT23_友好城市 {
    static int n;
    static int[][] dist;
    static int k;
    static int[] city;
    static int[] pei;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dist = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j]=sc.nextInt();
                if (i==j){
                    dist[i][j] = 0;
                }
            }
        }
        k=sc.nextInt();
        pei = new int[2*k];
        city = new int[2*k];
        for (int h = 0; h < 2*k; h++) {
            city[h] = sc.nextInt();
        }

        floyd();
        int[] vis = new int[n+1];
        dfs(k,vis,0);
        System.out.println(res);
    }

    private static void floyd() {
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) { // 入度
                for (int k = 1; k <=n ; k++) { // 出度
                    if (j == k || dist[j][i]==-1 || dist[i][k]==-1 ) continue;
                    if (dist[j][k]==-1 || dist[j][k] > dist[j][i] + dist[i][k]){
                        dist[j][k] = dist[j][i] + dist[i][k];
                    }
                }
            }
        }
    }


    private static void dfs(int k, int[] vis, int cur) {
        if (cur == 2*k){
            int distant = 0;
            for (int i = 0; i < 2*k; i+=2) {
                distant += dist[pei[i]][pei[i+1]];
            }
            res = Math.min(distant, res);
            return;
        }

        for (int i = cur; i < 2*k ; i++) {
            if (vis[i]==0){
                vis[i] = 1;
                pei[cur]=city[i];
                dfs(k, vis, cur+1);
                pei[cur]=0;
                vis[i] = 0;
            }
        }
    }

//    private static void dfs(int cnt, int total){
//        if(cnt == 2*k){
//            res = Math.min(res, total);
//            return;
//        }
//
//        for(int i=cnt+1; i<2*k; i++){
//            swap(i, cnt+1);
//            dfs(cnt+2, total+dist[city[cnt]][city[cnt+1]]);
//            swap(i, cnt+1);
//        }
//    }
//
//    /**
//     * 交换
//     * @param i
//     * @param j
//     */
//    private static void swap(int i, int j){
//        int tmp = city[i];
//        city[i] = city[j];
//        city[j] = tmp;
//    }

}
