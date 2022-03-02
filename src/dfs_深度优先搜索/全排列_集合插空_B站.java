package dfs_深度优先搜索;

import java.util.HashSet;
import java.util.Set;

public class 全排列_集合插空_B站 {
    public static void main(String[] args) {
        Set<String> set= getPermutation02("ABCd");
        System.out.println(set.size());
        System.out.println(set);
    }

    /*递归*/
    public static Set<String> getPermutation01(String insert){ //括号中是要进行全排列的字符串
        Set<String> end_res =new HashSet<String>();
        end_res.add(insert);
        if(insert.length()==1) return end_res;

        Set<String> temp = getPermutation01(insert.substring(1));// 下一级n-1的字符串子集
        Set<String> res=new HashSet<String>();
        char c =insert.charAt(0);
        for (String ele:temp){
            res.add(c + ele);//前插入
            res.add(ele + c);//后插入
            for (int i = 1; i <insert.length() ; i++) { //中间插入
                res.add(ele.substring(0,i) +c+ ele.substring(i));
            }//中间插入
        }
        return res;
    }

    /*迭代*/
    public static Set<String> getPermutation02(String insert){ //括号中是要进行全排列的字符串
        Set<String> res =new HashSet<String>(); //初始化, 将第一个字符加进去
        res.add(insert.charAt(0)+"");

        for (int i=1; i<insert.length();i++){
            Set<String> res_new=new HashSet<String>();
            char c =insert.charAt(i);

            for (String ele:res) {
                res_new.add(c + ele);//前插入
                res_new.add(ele + c);//后插入
                for (int j = 1; j < ele.length(); j++) { //中间插入
                    res_new.add(ele.substring(0, j) + c + ele.substring(j));
                }//中间插入}
            }
            res=res_new;
        }

        return res;
    }
}
