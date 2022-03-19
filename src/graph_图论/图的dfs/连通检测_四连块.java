package graph_图论.图的dfs;

import java.util.Scanner;

/**给定一个方阵，定义连通：上下左右相邻，并且值相同。
可以想象成一张地图，不同的区域被涂以不同颜色。
输入：
整数N, (N<50)表示矩阵的行列数
接下来N行，每行N个字符，代表方阵中的元素
接下来一个整数M，(M<1000)表示询问数
接下来M行，每行代表一个询问，
格式为4个整数，y1,x1,y2,x2，
表示询问(第y1行,第x1列) 与 (第y2行,第x2列) 是否连通。
连通输出true，否则false

例如：
10
0010000000
0011100000
0000111110
0001100010
1111010010
0000010010
0000010011
0111111000
0000010000
0000000000
3
0 0 9 9
0 2 6 8
4 4 4 6

程序应该输出：
false
true
true*/

public class 连通检测_四连块 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        char[][] graph = new char[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = scanner.nextLine().toCharArray();
        }
        int M = scanner.nextInt();
        int[][] query = new int[M][4];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 4; j++) {
                query[i][j] = scanner.nextInt();
            }
        }
        // M个起点和终点
        for (int i = 0; i < M; i++) {
            //对每个起点和终点，检查是否连通
            boolean ok = dfs(graph, new int[N][N], query[i]);
            System.out.println(ok);
        }
    }

    /**
     *
     * @param graph 原地图
     * @param label 标记地图--是否访问过
     * @param point 起点和终点坐标: x1,y2, x2,y2
     * @return 这个点是否能到达终点
     */
    static boolean dfs(char[][] graph, int[][] label, int[] point){
        //起点与终点
        int x1=point[0];
        int y1=point[1];
        int x2=point[2];
        int y2=point[3];

        /*step1. 递归退出条件*/
        if (x1==x2 && y1==y2)
            return true;

        //四连块的dfs包括上下左右四个方向的分支,每个分支返回是否能够到达终点
        boolean f1=false;
        boolean f2=false;
        boolean f3=false;
        boolean f4=false;

        int val_ok=graph[x2][y2]; //能走通的区域值--是0还是1还是其他

        /* 上*/
        /*step2. 剪枝条件: 1.不越界; 2.没访问过; 3.走得通*/
        if ((x1-1>=0) && (label[x1-1][y1]==0) && (graph[x1-1][y1]==val_ok)){
            label[x1-1][y1]=1;//标记成走过了
            point[0]=x1-1; //向上递归,起点变更
            f1 = dfs(graph,label,point);
            point[0]=x1;  /*step3. 回溯*/
            label[x1-1][y1]=0;
        }
        /*下*/
        if ((x1 + 1<graph.length) && (label[x1 + 1][y1]==0) && (graph[x1 + 1][y1]==val_ok)){
            label[x1 + 1][y1]=1;//标记成走过了
            point[0]=x1 + 1; //向上递归,起点变更
            f2 = dfs(graph,label,point);
            point[0]=x1;
            label[x1 + 1][y1]=0; //回溯回来
        }
        /*左*/
        if ((y1 - 1>=0) && (label[x1][y1 - 1]==0) && (graph[x1][y1 - 1]==val_ok)){
            label[x1][y1 - 1]=1;//标记成走过了
            point[1]=y1 - 1; //向上递归,起点变更
            f3 = dfs(graph,label,point);
            point[1]=y1;
            label[x1][y1 - 1]=0; //回溯回来
        }
        if ((y1 + 1 <graph[0].length) && (label[x1][y1 + 1]==0) && (graph[x1][y1 + 1]==val_ok)){
            label[x1][y1 + 1]=1;//标记成走过了
            point[1]=y1 + 1; //向上递归,起点变更
            f4 = dfs(graph,label,point);
            point[1]=y1;
            label[x1][y1+1]=0; //回溯回来
        }
        return f1||f2||f3||f4;
    } 
}
