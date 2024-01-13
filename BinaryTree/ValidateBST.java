package BinaryTree;

public class ValidateBST {
    public boolean isValidBST(TreeNode root) {
        return solve(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
    }
    boolean solve(TreeNode root,long left_range,long right_range)
    {
        if(root==null){
           return true;
         }
         if((root.val>=right_range) || (root.val<=left_range))
              return false;
        
         boolean left=solve(root.left,left_range,root.val);
         boolean right=solve(root.right,root.val,right_range);
           if(left && right)
                return true;
           return false;
        
    }
}
