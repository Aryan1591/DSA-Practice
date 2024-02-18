package BinaryTree;

public class SumRootToLeafNumbers {
    int ans=0;
    public int sumNumbers(TreeNode root) {
          if(root==null)return 0;
          solve(root,String.valueOf(root.val));
          return ans;
    }
     void solve(TreeNode root,String s)
    {
         if(root.left==null && root.right==null)
         {
               ans+=Integer.parseInt(s);
               return;
         }
         if(root.left!=null)
         {
             solve(root.left,s+String.valueOf(root.left.val));
         }
         if(root.right!=null)
         {
             solve(root.right,s+String.valueOf(root.right.val));
         }

    }
}
