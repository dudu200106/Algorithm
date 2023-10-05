package dfs_深度优先搜索;

import java.util.ArrayList;

public class DFS_组合 {
    //  用一个ArrayList装载可行解（也可以用stack）
    public static ArrayList<Integer> temp = new ArrayList<Integer>();
    //计数结果
    public static int count=0;
    static int size=3;//这里是输入的组合大小

    public static void main(String[] args){
        int[] u={0,0,0,0,0};
        dfs(u,0);
        System.out.println(count);
    }

    public static void dfs( int[] used,int k) {
        if (temp.size() == size) { //若不足规定的组合位数，丢掉
            count++;
            System.out.println(temp);
            return;
        }
        for (int i = k; i < used.length; i++) {
            if (used[i] == 0) {
                temp.add(i + 1);
                used[i] = 1;
                dfs(used, i+1);
                used[i] = 0; //回溯，因为需要恢复原来的状态，重新开始新的路径
                temp.remove(temp.size() - 1); //可行解出栈（虽然不是stack），让可行解回到原来的样子
            }
        }
    }

}
