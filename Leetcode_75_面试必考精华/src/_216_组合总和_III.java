import java.util.ArrayList;
import java.util.List;

/**
 * 这题是一题组合相关的问题, 关于组合,你需要知道:
 *      1.(有序元素,一般是数字元素)排序去重
 *      2.回溯方法, 以及引用对象必须得先深克隆, 才能加入集合, 不然会在回溯过程中为空
 *      3.二进制获取集合方法
 */
public class _216_组合总和_III {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    List<Integer> combination = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n,0,0, k);
        return res;
    }
    public void dfs(int n, int sum, int len, int k){
        if (len == k|| sum==n){
            if (sum==n && len == k){
                res.add(new ArrayList<>(combination));
            }
            return;
        }
        // 有序元素的集合去重的方法
        for (int i = combination.size()==0 ? 1 : combination.get(len-1)+1; i <=9 ; i++) {
            combination.add(i);
            dfs(n, sum+i,len+1,k);
            combination.remove(len);
        }
    }
}

