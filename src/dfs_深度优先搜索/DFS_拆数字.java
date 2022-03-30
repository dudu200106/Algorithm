package dfs_深度优先搜索;

import java.util.ArrayList;

/**
 * 拆数字类似cc150里的"硬币"(Coins)题目,只不过可选的"硬币"面值连续密集
 */
public class DFS_拆数字 {
    public static int ans=0;
    public static int num=5;
    public static ArrayList<Integer> temp1= new ArrayList<Integer>();

    public static void dfs(int temp,int x){
        if(temp>=num) {
            if (temp==num) {
                ans++;
                System.out.println(temp1);
            }
            return;
        }

        for (int i = 1; i <= num; i++) {
            temp=temp+i;
            temp1.add(i);
            dfs(temp,x);
            temp1.remove(temp1.size()-1);
            temp=temp-i;
        }
    }

    public static void main(String[] args) {
        int x=5;
        int t=0;
        dfs(t,x);
    }
}
