import java.util.*;

public class _236_二叉树的最近公共祖先 {

    HashMap<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> p_path = new HashSet<>();

    /**
     * 第一种方法是利用LCA节点的思想:
     *      LCA (x, y) 是 x 到根的路径与 y 到根的路径的第一次交汇点.
     *  我们先记录从节点p 到根节点的路径, 在遍历另一个节点q 到根节点的路径;
     *  那么第一个被记录到的q节点 的祖先节点, 就是节点p和q的最近公共祖先.
     *
     *  那么第一步便是遍历二叉树所有的节点, 用一个哈希表储存每个节点的父节点, 以方便后边存储遍历路径.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (p!=null){
            p_path.add(p.val);
            p= parent.get(p.val);
        }
        while(q != null){
            if (p_path.contains(q.val)){
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
    public void dfs(TreeNode root) {
        if (root.left != null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right!= null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
