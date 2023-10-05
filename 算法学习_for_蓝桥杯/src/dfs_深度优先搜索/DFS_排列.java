package dfs_深度优先搜索;

import java.util.ArrayList;

public class DFS_排列 {
    //  打表法,用一个ArrayList装载可行解
    static ArrayList<Integer> temp = new ArrayList<Integer>();
    static int count=0;  //计数结果
    static ArrayList<String> list = new ArrayList<String>();

    public static void main(String[] args){
        int[] u={0,0,0,0};
        dfs01(u,4);
        System.out.println(count);

        /*char[] ch= "1234".toCharArray();
        dfs02(ch,0);
        System.out.println(list.size());
        System.out.println(list);*/
    }

    /*记忆法, 使用打表法,不储存结果*/
    public static void dfs01( int[] used,int k) {
        if (temp.size() == 4) {
            count++;
            System.out.println(temp);
            return;
        }
        for (int i = 0; i < used.length; i++) {
            if (used[i] == 0) {
                temp.add(i + 1);
                used[i] = 1;
                dfs01(used, k);
                used[i] = 0; //回溯，因为需要恢复原来的状态，重新开始新的路径
                temp.remove(temp.size() - 1); //可行解出栈（虽然不是stack），让可行解回到原来的样子
            }
        }
    }

    /*交换法, 取消打表法,直接储存入结果集合中*/
    public static void dfs02( char[] arr,int k) {
        if (k == arr.length) {
            list.add(new String(arr));
        }
        for (int i = k; i < arr.length; i++) {
            util.util.swap(arr,k,i);
            dfs02(arr, k+1);
            util.util.swap(arr,k,i); //回溯，因为需要恢复原来的状态，重新开始新的路径
        }
    }

}
