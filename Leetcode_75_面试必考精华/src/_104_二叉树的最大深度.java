public class _104_二叉树的最大深度 {
    public int maxDepth(TreeNode root) {
        return dfs(root, 1);
    }

    public int dfs(TreeNode root, int depth){
        if (root==null)
            return depth-1;
        int maxDepth = depth;
        if (root.left != null){
            maxDepth = Math.max(maxDepth, dfs(root.left ,depth+1));
        }
        if (root.right != null){
            maxDepth = Math.max(maxDepth, dfs(root.right ,depth+1));
        }
        return maxDepth;
    }

}
