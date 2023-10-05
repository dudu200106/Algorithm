package dynamicPlanning_动态规划;

/**
 * 最长递增子序列的长度
 输入 4 2 3 1 5 6
 输出 3 （因为 2 3 5组成了最长递增子序列,不允许相等）

 * @author zhengwei 20171209
 */

/*
* 这里包含了三种解法:1.暴力解法
*                 2.与以往不同dp(最解结果不在最后,需要遍历dp数组)
*                 3.优化的dp(下标代表结果,数值代表长度为i的LIS的最小结尾值dp[i])
**/
public class LIS_最长上升子序列_B站 {

    public static void main(String[] args) {
         int[] arr = {4, 2, 3, 1, 5, 6, 4, 8, 5, 9};
        int start; //开始执行时间
        int end; //运行结束时间

        start = (int)System.nanoTime();
        System.out.println(force(arr));
        end =(int)System.nanoTime();
        System.out.println("force:" + (end - start) + "ns");

        start = (int)System.nanoTime();
        System.out.println(dp(arr));
        end =(int)System.nanoTime();
        System.out.println("dp:" + (end - start) + "ns");

        start = (int)System.nanoTime();
        System.out.println(dp1(arr));
        end =(int)System.nanoTime();
        System.out.println("dp1:" + (end - start) + "ns");


    }

    /*暴力解法*/
    static int force(int[] arr){
        int ans=1;
        for (int i = 0; i < arr.length; i++) { //以i开头的子字符串
            int cnt=1; //辅助计数当前LIS长度,初始值包含arr[i]自己一个
            int row=arr[i]; //结尾的最大值
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]>row){
                    cnt++;
                    row=arr[j];
                }
            }
            ans=Math.max(ans,cnt);
        }
        return ans;
    }

    /*略微怪异的dp*/
    static int dp(int[] arr){
        //dp[i]--以arr[i]结尾的LIS长度
        int[] dp=new int[arr.length];
        dp[0]=1; //以arr[i]结尾的LIS,初始化dp表数据
        for (int i = 1; i < arr.length; i++) { //递推,以arr[i]结尾的LIS值
            int cnt=1;
            for (int j = i-1; j >=0 ; j--) {
                if (arr[j]<arr[i]){
                    cnt=Math.max(cnt,dp[j]+1);
                }
            }
            dp[i]=cnt;
        }

        int maxDp=0;
        for (int i = 0; i < dp.length; i++) { //找出dp[]表中最大的LIS长度,不在是最后一个阶段的值
            maxDp=Math.max(maxDp,dp[i]);
        }
        return maxDp;
    }

    /*优化dp--下标代表结果大小,dp数值代表长度为i的LIS的最小结尾值dp[i]*/
    /*若是新增结尾字符arr[i]>dp[now],dp[now+1]=arr[i];
        不是的话从左往右找到第一个大于他的dp[j]值替换掉,这样dp[j]代表的长度为j的LIS的结尾始终是最小的,留给后边的操作空间越多(贪心)
    *
    * */
    static int dp1(int[] arr){
        int len=arr.length;
        int[] dp=new int[len+1]; //下标代表长度,数值代表结尾
        int p=1;
        dp[p]=arr[0];
        for (int i = 1; i <len ; i++) {
            if (dp[p]<arr[i]){ //新的数大于结尾值,LIS增长
                dp[++p]=arr[i];
            }
            else {
                for (int j = 1; j <= p; j++) { //找到第一个大于arr[]的LIS结尾,使它始终最小
                    if(dp[j]>arr[i]){
                        dp[j]=arr[i];
                        break;
                    }
                }
            }
        }
        return p;
    }
}
