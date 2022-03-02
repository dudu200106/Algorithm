package dfs_深度优先搜索;

import java.util.HashSet;
import java.util.Set;

/** n对括号有几种组合方式
 * 解法: 自底向上回溯的"左外右加括号"的方法(或者"第n个左括号插入法")
 *   这里采用每添加一层括号,就在左边/外边/右边 添加新括号的方法
 *  如: ()(),(())-->()()(),(()()),()(()),(())()
 */
public class 括号_cc150 {
    /*迭代方式*/
    public static Set<String> dfs1(int num){
        Set<String> res = new HashSet<String>();
        res.add("()");

        for(int n= 2; n<=num; n++){ //逐渐向上添加括号
            Set<String> newSet = new HashSet<String>(); //创建新集合
            for(String str:res){ //遍历旧集合,操作后加入新集合
                newSet.add("()"+str);
                newSet.add("("+str+")");
                newSet.add(str+"()");
            }
            res=newSet;
        }
        return res;
    }

    /*原递归--用回溯方法*/
    public static Set<String> dfs2(int num){
        Set<String> res=new HashSet<String>();
        res.add("()");

        if (num==1) return res; //栈底退出条件

        //自顶向下预先定义结果,等栈回溯的时候就获得了最终结果
        Set<String> temp= dfs2(num-1);
        Set<String> newSet=new HashSet<String>();//定义一个新集合集合
        //树的横向for循环
        for (String str:temp){
            newSet.add("()"+str);
            newSet.add("("+str+")");
            newSet.add(str+"()");
        }
        return newSet;
    }

    public static void main(String[] args) {
        System.out.println(dfs2(3));
    }
}
