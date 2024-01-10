package BinaryTree;

public class SumOfNodesWithEvenValuedGrandParents {
    public int sumEvenGrandparent(TreeNode root) {
        return sum(root);    
      }
      int sum(TreeNode root)
      {
          if(root==null)return 0;
           int ans=0;
          ans+=sum(root.left);
          ans+=sum(root.right);
             if(root.val%2==0)
             {
                 if(root.left!=null)
                   ans+=getSum(root.left);
                 if(root.right!=null)
                   ans+=getSum(root.right);  
             }
             return ans; 
      }
      int getSum(TreeNode root)
      {
          int sum=0;
           if(root.left!=null)
            sum+=root.left.val;
           if(root.right!=null)
            sum+=root.right.val;
           return sum;  
      }
}
