package dfs_深度优先搜索;

public class DFS_岛屿_水洼数 {
    public static void dfs01(int[][] a,int i,int j){
        a[i][j]=0;
//        int n=a.length;
//        int m=a[0].length;

        if(i>0&&a[i-1][j]==1)dfs01(a,i-1,j);//上
        if(i<a.length-1 &&a[i+1][j]==1)dfs01(a,i+1,j);//下
        if(j>0&&a[i][j-1]==1)dfs01(a,i,j-1);//左
        if(j<a[0].length-1 &&a[i][j+1]==1)dfs01(a,i,j+1);//右
        if(i>0 &&j>0 &&a[i-1][j-1]==1)dfs01(a,i-1,j-1);//上左
        if(i<a.length-1 &&j>0 &&a[i+1][j-1]==1)dfs01(a,i+1,j-1);//下左
        if(i>0 &&j<a[0].length-1 &&a[i-1][j+1]==1)dfs01(a,i-1,j+1);//上右
        if(i<a.length-1 &&j<a[0].length-1 &&a[i+1][j+1]==1)dfs01(a,i+1,j+1);//下右
    }

    public static void dfs02(int[][] a,int i,int j) {
        a[i][j] = 0;
        for (int k = -1; k < 2; k++) {
            for (int l = -1; l < 2; l++) {

                if (k == 0 && l == 0) continue;
                if (i + k < a.length && i + k >= 0 && j + l < a[0].length && j + l >= 0) {
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
