public class _463_岛屿的周长 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int n, m;

    public int islandPerimeter(int[][] grid) {
        n= grid.length;
        m = grid[0].length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1){
                    res = Math.max(res, dfs(i, j, grid) );
                }
            }
        }
        return res;
    }

    public int dfs(int x, int y, int[][] grid){
        if (x<0 || x>=n || y<0|| y >=m || grid[x][y]==0){
            return 1;
        }
        if (grid[x][y]==2){
            return 0;
        }

        int res =0;
        grid[x][y] = 2;
        for (int i = 0; i < 4; i++) {
            int tx = x+dx[i];
            int ty = y+dy[i];
            res += dfs(tx, ty, grid);
        }
        return res;
    }
}
