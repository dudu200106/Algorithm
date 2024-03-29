package dynamicPlanning_动态规划;

/**
 * 有n个重量和价值分别为wi，vi的物品，从这些物品中挑选出总重量不超过W的物品，求所有挑选方案中价值总和的最大值。
 *     1≤n≤100
 *     1≤wi，vi≤100
 *     1≤W≤10000
 *
 * 思路:
 * 完全背包问题每种物品数量无限,
 *
 * 首先,初始化的时候有所不同：初始化时，当只考虑一件物品为a时，dp[row][j] = values[row]*j/weight[row]
 * 然后dp方程式有所不同：dp[row][j] = max{dp[row-1][j],dp[row][j-w[row]] + v[row]}，
 * 要选择的时候，先选一个物品,减去重量，然后用去找上一个物品row-1在cap-w[i]状态下的最大值(dp[row-1][cap-w[i]] )，
 *     为什么匹配同一行，这是因为同一行同一种物品,剩下的容量转态中(cap-w[i] ),包含了选2个,3个...的最大dp值
 *
 * 必须理解，抓一个之后用剩余的容量重新考虑当前可选的所有物品其实包含了抓2个甚至更多的情况！！！
 * @author zhengwei
 */

public class 完全背包_B站 {
    public static void main(String[] args) {
        int[] values = {9, 5, 3, 1};
         int[] weights = {7, 4, 3, 2};
         int n = 4;
         int total = 10;
         dp(total,n,weights,values);
    }

    static void dp(int cap,int n,int[] w,int[] v){
        int[][] dp=new int[n+1][cap+1]; //物品类型编号from 1 to n
        //初始化数据--0行和0列的数据都为零,这里恰好不用写了,已经好了

        for (int i = 1; i <=n ; i++) { //物品种类下标
            for (int j = 1; j <= cap; j++) { //背包容量
                if (w[i-1]<=j){ //先判断够不够装
                    int v1=v[i-1]+dp[i][j-w[i-1]];//注意,这里和01背包不同
                    int v2=dp[i-1][j];//不选
                    dp[i][j]=Math.max(v1,v2);
                }
                else { //不够装就是不选,直接照搬上一种物品的dp[i-1][j]
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        System.out.println(dp[n][cap]);
    }
}
