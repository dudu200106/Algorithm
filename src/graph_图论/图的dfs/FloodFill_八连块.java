package graph_图论.图的dfs;

/**
 * 输入一个m行n列的字符矩阵，统计字符“@”组成多少个八连块。
 *  如果两个字符“@”所在的格子相邻（横、竖或者对角线方向），就说它们属于同一个八连块。
 *
 *  分析：图的dfs
 */

/*
* 八连块模板: (char[][] c, int[][] visited)
*
*  void dfs(int row, int col){ //作用: 扫描到一个后覆盖完掉一个八连块
*       if(...)退出条件
*
*       c[row][col]="*"; //覆盖八连块
*
*       dfs(row+1,col)
*       dfs(row-1,col)
*       dfs(row,col+1)
*       ...
*       (八个方向dfs)
*  }
* */
public class FloodFill_八连块 {

    private static char[][] data = {
            "*@@*@".toCharArray(),
            "**@*@".toCharArray(),
            "****@".toCharArray(),
            "@@@*@".toCharArray(),
            "@@**@".toCharArray(),
    };
    //记录区块数
    private static int cnt;

    public static void main(String[] args) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                if (data[i][j]=='@'){
                    dfs(i,j);
                    ++cnt;
                }
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int row, int col){
        if (row>=data.length||col>=data[0].length)
            return;
        if (row<0||col<0)
            return;
        if (data[row][col]=='*')
            return;

        data[row][col]='*';
        dfs(row+1,col);
        dfs(row-1,col);
        dfs(row+1,col+1);
        dfs(row-1,col-1);
        dfs(row,col+1);
        dfs(row,col-1);
        dfs(row+1,col-1);
        dfs(row-1,col+1);
    }
}
