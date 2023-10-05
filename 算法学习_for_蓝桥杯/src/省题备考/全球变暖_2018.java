package 省题备考;

import java.util.Arrays;
import java.util.Scanner;
/**你有一张某海域NxN像素的照片，"."表示海洋、"#"表示陆地，如下所示：

        .......
        .##....
        .##....
        ....##.
        ..####.
        ...###.
        .......

 其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有2座岛屿。

 由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，它就会被淹没。

 例如上图中的海域未来会变成如下样子：

        .......
        .......
        .......
        .......
        ....#..
        .......
        .......

 请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。

 【输入格式】
        第一行包含一个整数N。  (1 <= N <= 1000)
        以下N行N列代表一张海域照片。

        照片保证第1行、第1列、第N行、第N列的像素都是海洋。

 【输出格式】
        一个整数表示答案。

 【输入样例】
 7
 .......
 .##....
 .##....
 ....##.
 ..####.
 ...###.
 .......

 【输出样例】
  1
*/

/*
* 思路: 核心是"八连块"的变体, 加上两个修饰:上下左右临海的被淹没; 减少了多少岛屿
* 步骤: step1.计算原岛屿(四连块)数; step2.删除临海的岛屿像素; step3.计算删除后的四连块数
* 需要的方法:
*       1.count()方法: 计算图中岛屿的数量----count(int[][] graph, int row, int col)
*       2.delete()方法: 遍历删除临海的像素
* */

public class 全球变暖_2018 {
    public static int[] dx={1,0,-1,0};
    public static int[] dy={0,1,0,-1};

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        final int N=in.nextInt();
        char[][] data=new char[N][N];
        in.nextLine(); //很重要, 不然第一行会空null
        for (int i = 0; i < N; i++) {
            data[i]=in.nextLine().toCharArray();
        }
        util.util oo= new util.util();
        char[][] kkk=oo.copy(data);
        char[][] copy=oo.copy(data);
        int res= count(data,copy,N);
        System.out.println(res);
    }

    /** 统计消失岛屿数 */
    static int count(char[][] graph,char[][] old, int N){
        int cnt=0;
        int exist=0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j]=='#') {
                    boolean flag=dfs(graph,old, i, j);
                    cnt++;
                    if (flag) exist++;
                }
            }
        }
        return cnt - exist;
    }

    /**
     * 遍历整个岛屿,并判断岛屿是否存活
     * @param graph
     * @param old 原地图
     * @param row
     * @param col
     * @return 岛屿是否存活
     */
    static boolean dfs(char[][] graph, char[][] old, int row, int col){
        //边界
        if (row>=graph.length || row<0 || col>=graph.length || col<0)
            return false;
        if (graph[row][col]=='.')
            return false;

        boolean flag=true; //假设该岛屿会存活
        for (int i = 0; i < 4; i++) {
            int x1=row + dx[i];
            int y1=col + dy[i];
            if ( x1>graph.length-1 || x1<0 || y1> graph.length-1 || y1<0)
                continue;
            int temp=old[x1][y1]; //注意, dfs遍历后的岛屿被修改了, 要比较原地图
            if(temp=='.')
                flag=false;
        }

        graph[row][col]='.';
        //dfs邻居结点

        boolean f1=dfs(graph,old,row+dx[0],col+dy[0]);
        boolean f2=dfs(graph,old,row+dx[1],col+dy[1]);
        boolean f3=dfs(graph,old,row+dx[2],col+dy[2]);
        boolean f4=dfs(graph,old,row+dx[3],col+dy[3]);
        return flag || f1 ||f2 ||f3 || f4;
    }
}
