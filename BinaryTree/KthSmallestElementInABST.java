package BinaryTree;

public class KthSmallestElementInABST {
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        return solve(root,k);
    }
    int solve(TreeNode root,int k)
    {
         if(root==null)return -1;
         int left=solve(root.left,k);
         if(left==-1)
         {
             count++;
              if(k==count)return root.val;
              return solve(root.right,k);
         }
         return left;
    }
}
