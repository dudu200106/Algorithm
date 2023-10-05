package dfs_深度优先搜索;

public class DFS_岛屿_水洼数 {

    /**
     * 模板: (适用场景:允许更改原二维数组的八连/四连块)
     * for 原数组
     *      dfs() //遇到一个块就遍历,覆盖完整个块
     *      count++; //覆盖完这个块后计数加一
     *
     *      dfs(int[][]arr, int row, int col)
     *          1.退出条件
     *          2.剪枝 + 处理操作 + 继续递归+ 回溯
     *
     *
     * @param a
     * @param i
     * @param j
     */

    public static void dfs01(int[][] a,int i,int j){
        /** 1.退出条件 */
        if (i<0||i>=a.length) return;
        if (j<0||j>=a[0].length) return;
        if (a[i][j]==0) return;

        /** 2.剪枝 + 处理操作 + 继续递归+ 回溯*/
        a[i][j]=0;
        dfs01(a,i-1,j);//上
        dfs01(a,i+1,j);//下
        dfs01(a,i,j-1);//左
        dfs01(a,i,j+1);//右
        dfs01(a,i-1,j-1);//上左
        dfs01(a,i+1,j-1);//下左
        dfs01(a,i-1,j+1);//上右
        dfs01(a,i+1,j+1);//下右

    }

    public static int[] dx={0,1,-1};
    public static int[] dy={0,1,-1};
    public static void dfs02(int[][] a,int i,int j) {
        a[i][j] = 0;
        for (int k = -1; k <= 1; k++) {
            for (int l = -1; l <= 1; l++) {
                if (k == 0 && l == 0) continue; //原点不动,跳过
                if (i + k < a.length && i + k >= 0
                        && j + l < a[0].length && j + l >= 0) {
                    if (a[i + k][j + l] == 1) {
                        dfs02(a, i + k, j + l);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] b ={
                {0,0,1,0,0,0,0},
                {0,1,1,1,0,0,1},
                {0,0,1,0,0,1,1},
                {0,0,0,0,0,0,1},
                {0,0,1,1,1,0,0}
        };

        int count=0;
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if(b[i][j]==1) {
                    dfs02(b, i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
