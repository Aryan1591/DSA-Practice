package BinaryTree;

import java.util.Stack;

public class BST_Iterator {
     static Stack<TreeNode>s=new Stack<TreeNode>();
      
    public BST_Iterator(TreeNode root) {
          push_All(root);
    }
    
    public int next() {
        TreeNode current=s.pop();
         push_All(current.right);
           return current.val;
    }
    
    public boolean hasNext() {
         if(s.isEmpty()==false)
              return true;
          return false;
    }
     static void push_All(TreeNode root)
     {
         while(root!=null)
         {
             s.push(root);
              root=root.left;
         }
     }
}
