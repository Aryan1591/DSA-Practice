package BinaryTree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return getLCA(root,p,q);
    }
    TreeNode getLCA(TreeNode root,TreeNode p,TreeNode q)
    {
        if(root==null || root==p || root==q)
         return root;
        TreeNode left=getLCA(root.left,p,q);
        TreeNode right=getLCA(root.right,p,q);
        if(left!=null && right!=null)
           return root;
        if(left==null)
          return right;
        return left;   
    }
}
