import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class HJ43迷宫问题 {
    static int n=0;
    static int m=0;
    static int[][] g;
    static int[][] record;
    static int[] xt = {0,0,1,-1};
    static int[] yt = {1,-1,0,0};
    static ArrayList<String> res = new ArrayList<>();
    static ArrayList<String> temp = new ArrayList<>();


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        g = new int[n][m];
        record = new int[n][m];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                g[i][j] = in.nextInt();
            }
        }


        dfs(0,0);
        for(String e: temp){
            System.out.println(e);
        }

    }

    public static void dfs(int x, int y){
        res.add("("+x+","+y+")");

        if(x==n-1 && y==m-1){
            temp.addAll(res);
            return ;
        }
        for(int i=0; i<4; i++){
            int xx= x+xt[i];
            int yy= y+yt[i];
            if(xx<n && xx>=0 && yy<m && yy>=0){
                if(g[xx][yy] == 1 || record[xx][yy]==1)
                    continue;
                record[xx][yy] = 1;
                dfs(xx,yy);
                record[xx][yy] = 0;
                res.remove(res.size()-1);
            }
        }
    }
}
