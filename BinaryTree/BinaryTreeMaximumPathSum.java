package BinaryTree;

public class BinaryTreeMaximumPathSum {
    int maxi=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return maxi;
    }
     int solve(TreeNode root)
    {
        if(root==null)
             return 0;
        int left=solve(root.left);
         left=Math.max(0,left);
        int right=solve(root.right);
         right=Math.max(0,right);
        maxi=Math.max(maxi,root.val+left+right);
         return root.val+Math.max(left,right);
    }
}
