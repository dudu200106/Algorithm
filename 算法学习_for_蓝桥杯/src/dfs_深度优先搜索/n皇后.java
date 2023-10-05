package dfs_深度优先搜索;

/**
 * 请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个n*n的棋盘上放置n个棋子，
 * 使得每行每列和每条对角线上都只有一个棋子，求其 摆放的方法数。

 * 注意: 这是在求摆放的方法有多少种, 如果是检查的话很简单, 直接暴力解法

 给定一个int n，请返回方法数，保证n小于等于15
 *思路: 设计一个一维滚动数组posi[], 下标cur代表列x轴, 下标数值posi[cur]代表y轴;
 *      每个皇后独占一列(代表x轴),下标cur便是皇后编号;
 *      状态转移就是换下一列--换到下一个"皇后"的"地盘"下标(cur+1),
 *      平行状态就是换不同的数值位置(for posi[cur] from 1 to n-1);
 */

/*  模板:
 *      static int count;
 *      static int N; //皇后数
 *      dfs()
 *          fori //平行状态
 *              if(check()) //剪枝,判断posi[cur][row]处能否放置皇后
 *                  posi[cur]=i
 *                  dfs(posi,cur+1)
 *
 *      check(posi[],x,y)
 *          if(同一列是否有皇后) --与前一个皇后 在同一行
 *          if(正对角线是否有人) --与前一个皇后的横纵坐标和一致(x+y)
 *          if(斜对角线是否有人) --与前一个皇后的横纵坐标差一致(x-y)
 */

    /*
    * 收获:
    *  1. 学到了如何数值转下标
    * */
public class n皇后 {
    static int count=0; //方法计数
    static int N; //皇后数

    public static void main(String[] args) {
        N=7;
        int[] table=new int[N];

        dfs(table,0);
        System.out.println(count);
    }

    static void dfs(int[] posi,int cur){
        if (cur>=N) { //所有列检查完毕,符合要求就计数加一
            count++;
            return;
        }
        //row就是数值posi[cur]的值
        for (int row = 0; row < N; row++) {//位置转数值,将该编号皇后放入某行
            if (checkOK(posi,cur,row)){ //剪枝, 判断posi[cur][row]处能否放置皇后
                posi[cur]=row;
                dfs(posi,cur+1);
            }
        }
    }

    static boolean checkOK(int[] posi, int x, int y){ //判断posi[cur][row]处能否放置皇后
        for (int j = 0; j < x; j++) {
            //同一列
            if (posi[j]==y) return false;
            //正对角线--横纵坐标和--x+y永远一致
            if (j+posi[j]==x+y)  return false;
            //斜对角线--横纵坐标差--x-y永远一致
            if (j-posi[j]==x-y)  return false;
        }
        return true;
    }

}
