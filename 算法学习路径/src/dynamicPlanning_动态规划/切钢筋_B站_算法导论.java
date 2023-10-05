package dynamicPlanning_动态规划;

/*
Serling公司购买长钢条，将其切割为短钢条出售。切割工序本身没有成本支出。公司管理层希望知道最佳的切割方案。
假定我们知道Serling公司出售一段长为i英寸的钢条的价格为pi(i=1,2,…，单位为美元)。钢条的长度均为整英寸。

| 长度i | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
| - | - | - | - | - | - | - | - | - | - |
价格pi | 1 | 5 | 8 | 16 | 10 | 17 | 17 | 20 | 24 | 30 |

钢条切割问题是这样的：给定一段长度为n英寸的钢条和一个价格表pi(i=1,2,…n)，求切割钢条方案，使得销售收益rn最大。
注意，如果长度为n英寸的钢条的价格pn足够大，最优解可能就是完全不需要切割。

 例如:
 输入: int[] p = {1, 5, 8, 16, 10, 17, 17, 20, 24, 30};
 输出: 37

 */

import java.util.Arrays;

/**
 * 这是个一维的DP问题--a.有最优子结构
 *                  b.有重叠问题(比如f(9)中肯定包含f(5),f(4)之类的),
 *                  c.当前问题与历史可行解存在依赖关系
 *
 * 1.递归方程:f(n)= max[ p(1)+f(n-1), p(2)+f(n-2), ... ,p(n-1)+f(1) ] (p(x)代表把x长度的一段作为一整段)
 * 2.状态及转移方式: n的不同
 * 3.base case: n==0
 */
public class 切钢筋_B站_算法导论 {
    static int n=10; //总钢筋长度
    static int[] p = {1, 5, 8, 16, 10, 17, 17, 20, 24, 30}; //钢筋价值表
    static int[] vs=new int[n+1];

    public static void main(String[] args) {
        Arrays.fill(vs, -1);
        int ans = recur(n);
        System.out.println(ans);
        Arrays.fill(vs, 0);

        ans = dp();
        System.out.println(ans);
    }

    /*记忆型递归*/
    static int recur(int len){
        if (len==0) return 0; //base case

        int ans=0;
        for (int i = 1; i <=len ; i++) {
            if (vs[len-i]<0)  //备忘录里面没有,先存进去
                vs[len-i]=recur(len - i);
            int v = vs[len-i]+p[i-1]; //f(n-i)+p(i), p[]下标最大9
            ans = Math.max(ans, v);
        }
        return ans;
    }

    static int dp(){
        vs[0]=0;

        for (int i = 1; i <=n ; i++) { //状态转移:f(i)中i变化
            for (int j = 1; j <=i ; j++) { //i变成了f(i)的总钢筋长度(定义域),j作为一整段不断变长, 只能选择i之前的得到的答案
                vs[i]=Math.max(vs[i], vs[i-j]+p[j-1]); //函数p(10)对应数组p[9]
            }
        }
        return vs[10];
    }
}
