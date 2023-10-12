import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class _105_从前序与中序遍历序列构造二叉树 {
    public static int[] myPreOrder;
    public static int[] myInOrder;
    public static HashMap<Integer, Integer>  map = new HashMap<>();

    public TreeNode myBuildTree(int preLeft, int preRight, int inLeft, int inRight){
        if (preLeft>preRight){
            return null;
        }
        // 先由先序遍历找出root的值是多少(二叉树所有值唯一不重复)
        int pre_root_ind = preLeft;
        // 再通过哈希表找出root在中序遍历中的下标
        int in_root_ind = map.get(myPreOrder[pre_root_ind]);
        // 通过中序遍历的left和mid(root下标)相减, 得出左子树的长度size
        int leftSize = in_root_ind-inLeft;
        // 创建根节点, 并递归返回左右子树的根节点
        TreeNode rootNode = new TreeNode(myPreOrder[pre_root_ind]);
        rootNode.left = myBuildTree(preLeft+1, preLeft+leftSize, inLeft, in_root_ind-1);
        rootNode.right = myBuildTree(preLeft+leftSize+1, preRight, in_root_ind+1, inRight);

        return rootNode;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        myPreOrder = preorder;
        myInOrder = inorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return myBuildTree(0,preorder.length-1,0,inorder.length-1);
    }

    //迭代方法
    public TreeNode buildTree_diedai(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
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
