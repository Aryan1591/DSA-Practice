package BinaryTree;

public class MergeToBinaryTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return solve(root1,root2);
    }
    TreeNode solve(TreeNode root1,TreeNode root2)
    {
         
         if(root1==null)
          return root2;
         if(root2==null)
          return root1;
          TreeNode root = new TreeNode(root1.val+root2.val);
          root.left=solve(root1.left,root2.left);
          root.right=solve(root1.right,root2.right);
           return root;   
    }
}
