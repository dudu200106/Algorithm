package dfs_深度优先搜索;

import java.util.HashSet;
import java.util.Set;

/** n对括号有几种组合方式
 * 解法: 自底向上回溯的"左外右加括号"的方法(或者"第n个左括号插入法")
 *   这里采用每添加一层括号,就在左边/外边/右边 添加新括号的方法
 *  如: ()(),(())-->()()(),(()()),()(()),(())()
 *
 * 注意: 这里运用了Set不允许重复的特性, 在以后的特性中可以运用
 */
public class 括号_cc150 {


    /*迭代方式*/
    /**
     * 模板:
     *  HashSet<> res;
     *  res.add("()");
     *
     *  for i from 2 to num
     *      HashSet<> new;
     *      foreach ele  //每个元素前中后插入括号
     *          new.add( "()" +ele);
     *          new.add("(" +ele+ ")" );
     *          new.add(ele+ "()" );
     *      res=new;  //将新集合赋值给结果
     * */
    public static Set<String> dfs1(int num){
        /** step.1 创建结果集合,并初始化, 加入一对括号*/
        Set<String> res = new HashSet<String>();
        res.add("()");
        /** step.2 逐渐向下添加括号 */
        for(int n= 2; n<=num; n++){ //逐渐向下添加括号
            Set<String> newSet = new HashSet<String>(); //创建新集合
            /** step.3 前中后插入括号*/
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
        /* step.1 将一对括号插入结果集合, num==1退出递归,出栈*/
        Set<String> res=new HashSet<String>();
        res.add("()");
        if (num==1) return res; //栈底退出条件

        /* step.2 自顶向下获得下一阶段的dfs(num-1)结果集合*/
        //自顶向下预先定义结果,等栈回溯的时候就获得了最终结果
        Set<String> temp= dfs2(num-1);
        Set<String> newSet=new HashSet<String>();//定义一个新集合集合
        /* step.3 在上一个集合的所有元素前中后插入括号,然后加入新集合*/
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
