package dfs_深度优先搜索;

import java.util.HashSet;
import java.util.Set;

/** 给出一个数组, 求他的所有子集
 * 思路: 每个元素在子集中有两种状态:存在与不存在.
 *      故可以生成二叉树,每层的状态转移为是否添加元素"E"
 * 解题: 1.递归与迭代 2.二进制生成法(2^n -1)
 *
 * 注: 每个子集的生成也是dfs(沿着遍历路径生成), 只不过这里要所有结果而已
 */
public class 子集_B站 {
    /*迭代, 克隆一个旧的集合,然后在克隆集合中加入新的元素,再加入旧集合中*/
    public static Set<Set<Integer>> getSubset01(int[] arr, int cur){
        Set<Set<Integer>> res = new HashSet<>();//初始化
        res.add(new HashSet<>()); //加入空集

        for (int i = 0; i <= cur; i++) {
            Set<Set<Integer>> res_new=new HashSet<>();
            res_new.addAll(res);
            for (Set ele: res) {
                //深拷贝--Set是一个接口,而clone是一个受保护(protected)的方法
                Set<Integer> temp=(Set<Integer>)((HashSet)ele).clone();
                temp.add(arr[i]);
                res_new.add(temp);
            }
            res=res_new;
        }
        return res;
    }

    /*递归, f(n)=g(f(n-1))*/
    static Set<Set<Integer>> getSubset02(int[] arr,int cur){
        Set<Set<Integer>> res=new HashSet<>();
        res.add(new HashSet<>());
        if (cur<0)return res;

        res=getSubset02(arr,cur-1);
        Set<Set<Integer>> new_set=new HashSet<>();
        new_set.addAll(res);
        for (Set ele: res
             ) {
            Set<Integer> temp = (Set<Integer>)((HashSet)ele).clone();
            temp.add(arr[cur]);
            new_set.add(temp);
        }
        return new_set;
    }

    /*二进制法, ,用数的二进制每位代表数组中对应下标的元素,1是集合中存在,0是不存在*/
    static Set<Set<Integer>> getSubset(int[] arr,int length){
        Set<Set<Integer>> res=new HashSet<>();//初始化
        int num=(int)Math.pow(2,length);//二进制位组合个数
        for (int i = num; i >=0; i--) {
            Set<Integer> temp=new HashSet<>(); //每次创建一个空集合,放置
            for (int k=length-1;k>=0;k--){ //位移运算,从高位到低位检测每一位是否为1
                if(((i>>k)&1)==1) temp.add(arr[k]);
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4};
        Set<Set<Integer>> set=getSubset01(arr,arr.length-1);
        System.out.println(set.size() +"\n"+ set);
        set=getSubset02(arr,arr.length-1);
        System.out.println(set.size() +"\n"+ set);
        set=getSubset(arr,arr.length);
        System.out.println(set.size() +"\n"+ set);
    }
}
