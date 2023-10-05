package dynamicPlanning_动态规划;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 求最大公共子序列问题(两个字符串中最长的,可以顺序间隔的, 相同字符的集合)
 * 比如输入:
 * AB34C
 * A1BC2
 * 结果为: ABC
 * 更多案例请看测试用例
 * */

public class LCS_最长公共子序列_B站 {
    public static void main(String[] args) {

        LCS_最长公共子序列_B站 obj = new LCS_最长公共子序列_B站();
        int start = (int)System.nanoTime();
        ArrayList ans = obj.dfs("AB34C", "A1BC2");
        System.out.println(ans);
        System.out.println(obj.dfs("3563243", "513141"));
        System.out.println(obj.dfs("3069248", "513164318"));
        System.out.println(obj.dfs("123", "456"));
        int end =(int)System.nanoTime();
        System.out.println("dfs:" + (end - start) + "ns");

        start = (int)System.nanoTime();
        System.out.println(obj.solusion("AB34C", "A1BC2"));
        System.out.println(obj.solusion("3563243", "513141"));
        System.out.println(obj.solusion("3069248", "513164318"));
        System.out.println(obj.solusion("123", "456"));
        end =(int)System.nanoTime();
        System.out.println("dp:" + (end - start) + "ns");

        System.out.println(obj.solusion("acbd","abedc"));

    }

    /*两重循环的递递归*/
    /*
     递归dfs穷举所有不同字符开头的公共子序列--以一个字符串为基准,遍历俩字符串看以某个字符开头有没有相同的
    * */
    static ArrayList<Character> dfs(String s1, String s2){
        ArrayList<Character> list=new ArrayList<>();

        for (int i = 0; i < s1.length(); i++) { //s1的第i个字符后的字符串,
            ArrayList<Character> temp=new ArrayList<>();
            for (int j = 0; j < s2.length(); j++) { //s2的j之后的字符串
                if (s1.charAt(i)==s2.charAt(j)){ //剪枝条件:s1,s2中有没有s1.charAt(i)打头的公共子序列;
                    temp.add(s1.charAt(i)); //有的话把打头字符装入,继续dfs求他们的子字符串的LCS
                    temp.addAll(dfs(s1.substring(i+1),s2.substring(j+1)));
                    break; //跳出,剩余的由下一层dfs得出
                }
            }
            if (list.size()<temp.size())
                list=temp;
        }
        return list;
    }

    /* 状态转移函数(x,y分别指俩字符串长度):
        f(x,y) = f(x-1,y-1)+1/0()       ,s1.charAt(x)!=s2.charAt(y)
               = max{f(x-1,y),f(x,y-1)} ,else
     * 通过画dp table我们发现, 新增LCS字符只可能是s1,s2范围都新增了一个字符且俩字符相同时;不同就比较俩只增加一遍的dp值谁大
    dp表的初始化部分为第一行和第一列;
    从dp[2][2]开始递推,根据状态转移函数,我们可以它左上角的三个dp值,做出三种选择:
        1. 先看s1,s2的字符串的范围都新增一个字符,若是新增的俩字符相同,就会参与贡献,就可能改变原状态dp[i-1][j-1]使得LCS长度+1:
             dp[i][j]=原dp[i-1][j-1] + 判断(俩新增字符相等+1,不相等+0)
        2. 只s1范围+1,只新增一边的字符,没有什么改变dp[i-1][j-1],使LCS增长的贡献: dp[i][j]=左dp[i][j-1]
        3. 只s2新增一个字符,同上,没用: dp[i][j]=上dp[i-1][j]
    如何选择: 先看选择1各增加一个的字符是否相等,不等就比较2,3两种选择谁更大

    */
    static String solusion(String s1, String s2){
        int len1=s1.length();
        int len2=s2.length();
        int[][] dp=new int[len1+1][len2+1];

//        可以不用初始化数据,递推dp数组的时候从1开始就行;缺点就是执行时间慢--多出了一行一列要递推dp
        //初始化第一列(),s2字符为列
        int flag=0;
        for (int j = 1; j <= len1; j++) {
            if (flag==1){
                dp[j][1]=1;
            }
            else if (s1.charAt(j-1)==s2.charAt(0)) {
                flag=1;
                dp[j][1] = 1;
            }
            else
                dp[j][1]=0;
        }

        //初始化第一行(),s1的字符代表行
        flag=0; //代表还没找到相同字符
        for (int i = 1; i <= len2; i++) {
            if (flag==1){
                dp[1][i]=1;
            }
            else if (s1.charAt(0)==s2.charAt(i-1)) {
                flag=1;
                dp[1][i] = 1;
            }
            else
                dp[1][i]=0;
        }

        //开始递推
        //dp选择与择优:i和j分别代表了两个字符串的范围
        for (int i = 2; i <= len1; i++) { //s1
            for (int j = 2; j <= len2; j++) { //s2
                if (s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1; //新增了俩相等字符,直接在原状态dp值上+1,它肯定是左上角三个值最大的
                }
                else { //俩新增字符不同,就找max( dp[i-1][j],dp[i][j-1] )
                    int maxOfLeftUp=Math.max(dp[i-1][j],dp[i][j-1]);
                    dp[i][j] = maxOfLeftUp;
                }
            }
        }
        return parseDp(dp,s1,s2);
    }

    /*从最终dp table的数值结果,逆推LCS的结果*/
    static String parseDp(int[][] dp,String s1,String s2){
        int M = s1.length(); //M,N就是开始坐标
        int N = s2.length();
        StringBuilder sb = new StringBuilder();
        while (M > 0 && N > 0) {
            // 比左和上大，一定是当前位置的字符相等
            if (dp[M][N] > Math.max(dp[M - 1][N], dp[M][N - 1])) {
                sb.insert(0, s1.charAt(M - 1));
                M--;
                N--;
            } else {  // 一定选择的是左边和上边的大者
                if (dp[M - 1][N] > dp[M][N - 1]) {
                    M--;  //往上移
                } else {
                    N--; // 往左移
                }
            }
        }

        return sb.toString();

    }
}
