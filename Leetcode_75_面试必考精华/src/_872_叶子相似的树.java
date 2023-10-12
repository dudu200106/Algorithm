import java.util.ArrayList;
import java.util.List;

public class _872_叶子相似的树 {

    /**
     * 直接深度优先遍历二叉树, 把叶子节点收集起来比较就完了
     * @param root1
     * @param root2
     * @return
     */
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> leaf1 = new ArrayList<>();
        ArrayList<Integer> leaf2 = new ArrayList<>();
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    public void dfs(TreeNode root, List<Integer> list){
        if (root.left == null && root.right==null){
            list.add(root.val);
            return;
        }
        if (root.left != null){
            dfs(root.left, list);
        }
        if (root.right != null){
            dfs(root.right, list);
        }
    }

}
