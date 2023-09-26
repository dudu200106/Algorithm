package dynamicPlanning_动态规划;

/*
有n个重量和价值分别为wi，vi的物品，从这些物品中挑选出总重量不超过W的物品，求所有挑选方案中价值总和的最大值。
    1≤n≤100
    1≤wi，vi≤100
    1≤W≤10000

输入：
    n=4
    (w,v)={(2,3),(1,2),(3,4),(2,2)}
    W=5

输出：
    7（选择第0，1，3号物品）
因为对每个物品只有选和不选两种情况，所以这个问题称为01背包。

 */

import java.util.Arrays;

/**
 *  因为对每个物品只有选和不选两种情况，所以这个问题称为01背包。
 *          0/1背包的核心: 第i个物品的放与不放
 *
 * 1.明确状态（x）： 物品指针：cur，与 容量： cap
 * 2.dp方程目的（f(x,y)）：dp(物品指针cur,容量cap）=背包装下的最大价值；
 * 3.状态转移方式(自变量)：cap与cur的变换
 * 4.base case(最小边界值)：cap==0 ， cur==3；
 * 5.构造dp table（dp数组，二维）
 */
public class 最大价值_01背包 {
    static int[] weight={0,2,3,4,7};
    static int[] value={0,1,3,5,9};
    static int n=4;
    static int Cap=10;
    static int[][] rec=new int[n][Cap+1];
    static { //静态代码块,每次运行main方法前先执行里面的代码
        for (int i = 0; i < n; i++) {
            Arrays.fill(rec[i],-1);
        }
    }

    public static void main(String[] args) {
        int res=dfs(1,Cap);
        int start = (int)System.nanoTime();
        System.out.println(res);
        int end =(int)System.nanoTime();
        System.out.println("dfs:" + (end - start) + "ns");

        start = (int)System.nanoTime();
        System.out.println(iterate(Cap,1));
        end =(int)System.nanoTime();
        System.out.println("iterate:" + (end - start) + "ns");

        start = (int)System.nanoTime();
        System.out.println(dp());
        end =(int)System.nanoTime();
        System.out.println("dp:" + (end - start) + "ns");

    }

    /*dfs版本*/
    static int dfs(int cur, int cap){
        if (cur==5) return 0; //装完退出
        if (cap<=0) return 0; //装完装不下了

        int v1=dfs(cur+1,cap); // 不装
        if (cap < weight[cur])
            return v1;
        else{
            int v2=dfs(cur+1,cap-weight[cur])+ value[cur];
            return Math.max(v1,v2);
        }
    }

    /*记忆型递归--相当于在数组里就“剪枝”，返回其在数组中的值*/
    static int iterate(int cap, int cur){
        //1.base case
        if (cap<=0) return 0;
        if (cur==4) return 0;
        //2.先在备忘录里查询
        if (rec[cur][cap]>=0) return rec[cur][cap];
        //3.正常递归穷举
        int ans;
        int v1=dfs(cur+1,cap);
        if (cap>=weight[cur]){
            int v2=value[cur]+dfs(cur+1, cap-weight[cur]);
            ans=Math.max(v1,v2);
        }
        else {
            ans=v1;
        }
        rec[cur][cap]=ans;
        return ans;
    }

    /*动态规划版本,dp table的建立*/
    static int dp(){
        //1.创建dp table
        int[][] dp=new int[n+1][Cap+1];

        //3.开始实例化,递推其他行的结果(自底向上)
        for (int i = 1; i < n+1 ; i++) {
            for (int j = 1; j < Cap+1; j++) {
                //若是要得起
                if (j>=weight[i]){
                    int v1=value[i]+dp[i-1][j-weight[i]]; //要
                    int v2=dp[i-1][j];//不要
                    //放入dp表中
                    dp[i][j]=Math.max(v1,v2);
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][Cap];
    }

}
