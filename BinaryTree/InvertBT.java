package BinaryTree;

public class InvertBT {
    public TreeNode invertTree(TreeNode root) {
        return invert(root);
    }
    TreeNode invert(TreeNode root)
    {
        if(root==null)return null;
        TreeNode right=invert(root.right);
        TreeNode left=invert(root.left);
        root.left=right;
        root.right=left;
         return root;
    }
}
