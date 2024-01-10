package BinaryTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class FindElementsInaContaminatedBT {
     Set<Integer>set;
    public FindElementsInaContaminatedBT(TreeNode root) {
        set=new HashSet<>();
        Queue<TreeNode>q=new LinkedList<>();
        root.val=0;
        q.add(root);
         while(!q.isEmpty())
         {
             TreeNode node = q.peek();
             q.remove();
             set.add(node.val);
             if(node.left!=null)
             {
                 node.left.val=2*node.val+1;
                 q.add(node.left);
             }
             if(node.right!=null)
             {
                 node.right.val=2*node.val+2;
                 q.add(node.right);
             }
         }
    }
    
    public boolean find(int target) {
        return set.contains(target);
    }
}
