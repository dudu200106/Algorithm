public class 二叉树中的最大路径和_二叉树 {

    /**二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。
    同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
    路径和 是路径中各节点值的总和。
    给你一个二叉树的根节点 root ，返回其 最大路径和 。
    */

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftSum = Math.max(0, maxGain(root.left)); // 若子节点最大贡献值为负, 不加入该子节点,当做0
        int rightSum = Math.max(0, maxGain(root.right));
        int curPathSum = rightSum + leftSum +root.val;
        maxSum = Math.max(maxSum, curPathSum);
        return root.val + Math.max(leftSum, rightSum); // 最大贡献值最多只能包含一个子节点
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
