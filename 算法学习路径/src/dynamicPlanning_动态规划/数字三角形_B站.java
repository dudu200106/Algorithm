package dynamicPlanning_动态规划;

import java.util.Scanner;

/**
 * 数字三角形(POJ1163)<br>
 *
 * 在数字三角形中寻找一条从顶部到底边的路径，使得路径上所经过的数字之和最大。<br>
 * 路径上的每一步都只能往左下或 右下走。只需要求出这个最大和即可，不必给出具体路径。<br>
 * 三角形的行数大于1小于等于100，数字为 0 - 99<br>
 * 输入格式：<br>
 * 5 //表示三角形的行数 接下来输入三角形<br>
 *      7<br>
 *     3 8<br>
 *    8 1 0<br>
 *   2 7 4 4<br>
 *  4 5 2 6 5<br>
 * 要求输出最大和<br>
 *
 * @author zhengwei
 *
 */

/*
 思路: 可以用二叉树的遍历加上剪枝parent+=p[0][0]+max(p[0][1],p[1][1]);
        但一看就是二维的dp,可以转换成二维数组的形式
 X/Y 0 1 2 3 4
 *************
 0*  7
 1*  3 8
 2*  8 1 0
 3*  2 7 4 4
 4*  4 5 2 6 5
 且
    a.有最优子结构--父节点的结果肯定能由俩子节点的最大值中得来
    b.重叠子问题
    c.求的是路径最大经过值,不可能预知未来
    d.当前问题只依赖下一行的历史结果,可以使用滚动数组,覆盖历史结果

* */
public class 数字三角形_B站 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] triangle = new int[n][]; //如此,可动态创建三角形的数组,
        for (int i = 0; i < n; i++) {
            triangle[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = sc.nextInt();
            }
        }

        /*数据量还小,出现了dp比recursion还慢的情况*/
        int start = (int)System.nanoTime();
        System.out.println(dp(triangle));
        int end =(int)System.nanoTime();
        System.out.println("dp:" + (end - start) + "ns");

        start = (int)System.nanoTime();
        System.out.println(recur(triangle,0,0));
        end =(int)System.nanoTime();
        System.out.println("recursion:" + (end - start) + "ns");
    }

    /*直接dp形式*/
    static int dp(int[][] triangle ){
        int rowCount=triangle.length;
        int columnCount=triangle[rowCount-1].length;
        int[] dp = new int[columnCount]; //创建dp滚动数组
        for (int k = 0; k < columnCount; k++)
            dp[k] = triangle[rowCount - 1][k];//初始化最后一行

        for (int i = rowCount-2; i >=0 ; i--) {
            for (int j =0; j <triangle[i].length; j++) {
                dp[j]=triangle[i][j]+Math.max(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }

    static int recur(int[][] tri,int i,int j){
        if (i==tri.length-1) return tri[i][j];

        else return tri[i][j]+
                    Math.max(recur(tri,i+1,j), recur(tri,i+1,j+1));
    }
 }
