package BinaryTree;

public class MaximumSumBSTInABinaryTree {
    int ans=0;
    public int maxSumBST(TreeNode root) {
        if(root==null)
           return 0;
        preOrder(root);
         return ans;  
    }
    Node preOrder(TreeNode root)
    {
         if(root==null)
         {
             return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
         }
        Node left=preOrder(root.left);
        Node right=preOrder(root.right);
        if(left.maxValue<root.val && root.val<right.minValue) //valid
        {
            ans=Math.max(ans,root.val+left.sum+right.sum);
            return new Node(Math.min(root.val,left.minValue),Math.max(root.val,right.maxValue),root.val+left.sum+right.sum);
        }

        
            return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE,0);
         
    }
   
}
class Node
{
    int sum;
    int maxValue;
    int minValue;
      Node(int minValue,int maxValue,int sum)
      {
          this.minValue=minValue;
          this.maxValue=maxValue;
          this.sum=sum;

      }
}

