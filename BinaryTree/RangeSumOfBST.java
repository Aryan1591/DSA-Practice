package BinaryTree;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int low, int high) {
        return solve(root,low,high);
    }
    int solve(TreeNode root,int l,int r)
    {
        if(root==null)
        return 0;

        if(root.val>=l && root.val<=r)
          return root.val+solve(root.left,l,r)+solve(root.right,l,r);
        else if(root.val<l)
        return solve(root.right,l,r);
        
        else 
        return solve(root.left,l,r);
        
    } 
}
