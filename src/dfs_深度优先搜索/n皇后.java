package dfs_深度优先搜索;

/**
 * 请设计一种算法，解决著名的n皇后问题。这里的n皇后问题指在一个n*n的棋盘上放置n个棋子，
 * 使得每行每列和每条对角线上都只有一个棋子，求其摆放的方法数。

 给定一个int n，请返回方法数，保证n小于等于15
 *思路: 位置转数值(y轴),变换位置即遍历x轴数值:
 *      每个皇后独占一列(代表x轴),只需构造一个一维posi数组----下标cur代表列col(x轴),posi[cur]代表行row(y轴),
 *      状态转移就是换下一列--换到下一个"皇后"的"地盘"(cur+1), 平行状态就是换不同的位置(for posi[cur] from 1 to n-1)
 */
public class n皇后 {

    static int count=0;

    static void dfs(int n,int[] posi,int cur){
        if (cur>=n) {
            count++;
            return;
        }

        for (int row = 0; row < n; row++) {//位置转数值, 变换位置即遍历数值
            if (checkOK(posi,cur,row)){ //剪枝, 判断posi[cur][row]处能否放置皇后
                posi[cur]=row;
                dfs(n,posi,cur+1);
            }
        }
    }

    static boolean checkOK(int[] p, int x, int y){ //cur数组下标相当于当前x,row就是转换成数值的y
        for (int j = 0; j < x; j++) {
            if (p[j]==y) return false;
            if (j+p[j]==x+y){ //斜对角线
                return false;
            }
            if (j-p[j]==x-y) { //正对角线
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] table=new int[4];
        dfs(4,table,0);
        System.out.println(count);
    }
}
