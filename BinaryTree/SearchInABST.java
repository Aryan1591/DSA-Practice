package BinaryTree;

public class SearchInABST {
    public TreeNode searchBST(TreeNode root, int val) {
        return solve(root,val); 
     }
     TreeNode solve(TreeNode root,int val)
     {
         if(root==null || root.val==val)
          return root;
         if(root.val<val)
          return solve(root.right,val);
          return solve(root.left,val);
     }
}
