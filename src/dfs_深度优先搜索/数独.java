package dfs_深度优先搜索;

import java.util.Scanner;

/*
你一定听说过“数独”游戏。
如下图所示，玩家需要根据9×9盘面上的已知数字，推理出所有剩余空格的数字，并满足每一行、每一列、每一个同色九宫内的数字均含1-9，不重复。
数独的答案都是唯一的，所以，多个解也称为无解。
本图的数字据说是芬兰数学家花了3个月的时间设计出来的较难的题目。但对会使用计算机编程的你来说，恐怕易如反掌了。
本题的要求就是输入数独题目，程序输出数独的唯一解。我们保证所有已知数据的格式都是合法的，并且题目有唯一的解。
格式要求，输入9行，每行9个数字，0代表未知，其它数字为已知。
输出9行，每行9个数字表示数独的解。
输入：

005300000
800000020
070010500
400005300
010070006
003200080
060500009
004000030
000009700

程序应该输出：

145327698
839654127
672918543
496185372
218473956
753296481
367542819
984761235
521839764

再例如，输入：

800000000
003600000
070090200
050007000
000045700
000100030
001000068
008500010
090000400

程序应该输出：

812753649
943682175
675491283
154237896
369845721
287169534
521974368
438526917
796318452
*/

/*
  收获:
  1. 学习了二维数组在dfs中的换行 --> dfs(x+(y+1)/9, (y+1)%9)
  2. 在不断穷举试错的搜索中, 回溯 是比较常见的选择
  3. 在2.的基础上延伸, dfs也非常适合二维数组的连通性和可达性分析
*/

public class 数独 {
    public static void main(String[] args) {
        // System.out.println((char)('0'+1));
        Scanner sc = new Scanner(System.in);
        char[][] table = new char[9][];
        for (int i = 0; i < 9; i++) {
            table[i] = sc.nextLine().toCharArray();
        }
//        print(table);
        dfs(table, 0, 0);
    }
    /**
     * 模板:
     *
     * */
    private static void dfs(char[][] table, int x, int y) {
        //退出--x超过最后一行
        if (x==9) {
            print(table);
            System.exit(0);
        }

        if(table[x][y]=='0'){
            for (int k = 1; k <=9 ; k++) {
                if (check(table,x,y,k)) {
                    table[x][y] = (char)('0'+k);
                    dfs(table, x + (y + 1) / 9, (y + 1) % 9);//实现在dfs遍历过程中, 二维数组的换行
                }
            }
            table[x][y]='0'; //若是所有数字都不满足条件,回溯为零
        }
        else
            dfs(table,x + (y + 1) / 9, (y + 1) % 9);

    }


    private static boolean check(char[][] table, int i, int j, int k) {
        //检查同行和同列
        for (int l = 0; l < 9; l++) {
            if (table[i][l]==(char)(k+'0')) return false;
            if (table[l][j]==(char)(k+'0')) return false;
        }
        //检查小九宫格
        for (int m=(i/3)*3; m < (i/3+1)*3; m++) {
            for (int n = (j/3)*3; n <(j/3+1)*3; n++) {
                if (table[m][n]==(char)('0'+k)) return false;
            }
        }
        return true;
    }

    private static void print(char[][] table) {
        for (int i = 0; i < 9; i++) {
            System.out.println(new String(table[i]));
        }
    }
}
