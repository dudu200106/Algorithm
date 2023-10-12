import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class _129_求根节点到叶节点数字之和_二叉树 {

    public int sumNumbers(TreeNode root) {
        return dfs(0,root);
    }

    static int dfs(int pre_sum, TreeNode root){
        if (root ==null){
            return 0;
        }
        pre_sum= pre_sum*10+root.val;
        if(root.left ==null && root.right==null)
            return pre_sum;
        return dfs(pre_sum, root.left)+ dfs(pre_sum, root.right);
    }

    static int bfs(TreeNode root){
        if (root ==null){
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> numQueue = new LinkedList<>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while(!nodeQueue.isEmpty()) {
            TreeNode cur_node = nodeQueue.poll();
            int cur_num = numQueue.poll();
            if (root.left == null && root.right == null) {
                sum += cur_num;
                continue;
            }
            if (root.left != null) {
                nodeQueue.offer(root.left);
                numQueue.offer(cur_num*10 +root.left.val);
            }
            if (root.right != null) {
                nodeQueue.offer(root.right);
                numQueue.offer(cur_num*10 +root.right.val);
            }
        }
        return sum;
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
