import java.util.HashMap;

public class _437_路径总和_III {

    /**
     * 前缀和 + dfs
     */
//    static HashMap<Long,Integer> preSum = new HashMap<>();
//
//    public int pathSum(TreeNode root, int targetSum) {
//        preSum.put(0L,1);
//        return dfs(root, targetSum, 0);
//    }
//
//    static int dfs(TreeNode root, int targetSum, long pre_val){
//        if(root == null)
//            return 0;
//        int res= 0;
//        long cur_sum = root.val + pre_val;
//        long diff = cur_sum - targetSum; // 差
//        res += preSum.getOrDefault(diff, 0);
//        preSum.put(cur_sum, preSum.getOrDefault(cur_sum, 0) + 1);
//        res += dfs(root.left, targetSum, cur_sum) + dfs(root.right, targetSum,cur_sum);
//        preSum.put(cur_sum, preSum.getOrDefault(cur_sum, 0) - 1);
//        return res ;
//    }

    /**
     * 纯dfs, 枚举遍历所有节点为起点的路径和是否等于targetSum
     *
     * 分两个函数,请学习其中的方法 -- 即"以任意结点为根(起点), 向下搜索"的情况
     */

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        int res = dfs(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public int dfs(TreeNode root, long targetSum){
        if (root == null)
            return 0;
        int res = 0;
        if (root.val == targetSum)
            res++;
        res += dfs(root.left, targetSum - root.val);
        res += dfs(root.right, targetSum - root.val);
        return res;
    }
}
