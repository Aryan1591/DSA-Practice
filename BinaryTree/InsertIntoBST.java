package BinaryTree;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null)
         return new TreeNode(val);
        TreeNode node = root;
         while(node!=null)
         {
             if(node.val>val)
             {
                 if(node.left==null)
                 {
                     node.left=new TreeNode(val);
                      break;
                 }
                 else{
                     node=node.left;
                 }
             }
             else{
                 if(node.right==null)
                 {
                     node.right=new TreeNode(val);
                      break;
                 }
                 else{
                      node=node.right;
                 }
             }
         }
          return root; 
   }
}
