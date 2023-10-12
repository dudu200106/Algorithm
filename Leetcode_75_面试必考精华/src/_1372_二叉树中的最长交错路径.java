import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class _1372_二叉树中的最长交错路径 {


    /**
     * 动态规划的思想
     *
     * 1.首先遍历二叉树的给个节点
     * 2.若节点root的 左节点u 存在, 那么规定函数l(u)则为以u结尾的、最长的交错路径；
     *      l（u）= r（parent[u]）+1;
     *
     *若节点root的 右节点v 存在, 那么规定函数r(u)则为以u结尾的、最长的交错路径；
     *      r（u）= l（parent[u]）+1;
     * 3.用两个哈希表维护这两个函数, key-value形式为(TreeNode, Integer), 最后遍历这两个函数哈希表的最大value值
     */
    HashMap<TreeNode, Integer> l_map = new HashMap<>();
    HashMap<TreeNode, Integer> r_map = new HashMap<>();
//    public int longestZigZag(TreeNode root) {
//        dp_bfs(root);
//        int max_res = 0;
//        for(int ele: l_map.values()){
//            max_res = Math.max(max_res, ele);
//        }
//        for(int ele: r_map.values()){
//            max_res = Math.max(max_res, ele);
//        }
//        return max_res;
//    }
    Queue<TreeNode> queue = new LinkedList<>();
    public void dp_bfs(TreeNode root){
        if (root == null)
            return;
        queue.add(root);
        l_map.put(root,0);
        r_map.put(root,0);
        while (queue.size() != 0){
            TreeNode ele = queue.poll();
            if (ele.left!=null){
                queue.offer(ele.left);
                l_map.put(ele.left, r_map.getOrDefault(ele, 0) + 1);
            }
            if (ele.right != null){
                queue.offer(ele.right);
                r_map.put(ele.right, l_map.getOrDefault(ele, 0) + 1);
            }
        }
    }


    /**
     * 下面使用dfs深度优先实现的, 空间复杂度减低了, 但时间复杂度提升至O(n^2)
     */
    int max_res = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root, "l", 0);
        dfs(root, "r", 0);

        return max_res;
    }

    public void dfs(TreeNode root, String dir, int len){
        max_res = Math.max(max_res, len);

        if ("l".equals(dir)){
            if (root.right != null){
                dfs(root.right, "r", len+1);
            }
            if (root.left != null){
                dfs(root.right, "l", 1);
            }
        }else {
            if (root.right != null){
                dfs(root.right, "r", 1);
            }
            if (root.left != null){
                dfs(root.right, "l", len+1);
            }
        }
    }


}
