package BinaryTree;

public class MaximumBinaryTree2 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        return solve(root,val);
    }
     TreeNode solve(TreeNode root,int val)
     {
         if(root==null)
         {
             return  new TreeNode(val);
         }
         else if(root.val<val)
         {
             TreeNode head=new TreeNode(val);
              head.left=root;
               return  head;
         }
         else {
               TreeNode node=solve(root.right,val);
                 root.right=node;
                  return root;
         }
     } 
}
