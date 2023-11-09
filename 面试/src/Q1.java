import java.util.ArrayList;
import java.util.List;

public class Q1 {

/**
 * 全排列：给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * 输入：nums = [1]
 * 输出：[[1]]
 */

    static List<Integer> p = new ArrayList<>();;
    static List<List<Integer>> res = new ArrayList<>();;
    public static List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        dfs(nums, new int[n],0,n);
        return res;
    }

    public static void dfs(int[] nums, int[] help, int cur, int n){
        if (cur==n){
            ArrayList temp = new ArrayList();
            temp.addAll(p);
            res.add(temp);
        }
        for (int i = 0; i < n; i++) {
            int cur_num = nums[i];
            if (help[i]==0){
                p.add(cur_num);
                help[i]=1;
                dfs(nums, help, cur+1, n);
                help[i]=0;
                p.remove(cur);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}).toString());
    }

}
