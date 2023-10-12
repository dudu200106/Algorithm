public class _1448_统计二叉树中好节点的数目 {

    public int goodNodes(TreeNode root) {
        return dfs(root,Integer.MIN_VALUE);
    }

    static int dfs(TreeNode root, int max_val){
        System.out.println(root.val);
        if (root == null)
            return 0;
        int res = 0;
        int cur_val = root.val;
        if (cur_val >= max_val){
            res=1;
            max_val = cur_val;
        }
        return res + dfs(root.left, max_val)+dfs(root.right, max_val);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
