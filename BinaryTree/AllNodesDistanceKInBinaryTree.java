package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AllNodesDistanceKInBinaryTree {
     public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap=  fillParent(root);
        Queue<TreeNode>q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> vis = new HashSet<>();
        vis.add(target);
        while(!q.isEmpty() && k-->0)
        {
            int size = q.size();
            for(int i=0;i<size;i++){
            TreeNode node = q.peek();
            q.remove();
            if(node.left!=null && !vis.contains(node.left))
            {
                q.add(node.left);
                vis.add(node.left);
            }
            if(node.right!=null && !vis.contains(node.right))
            {
                 q.add(node.right);
                 vis.add(node.right);
            }
            if(parentMap.get(node)!=null && !vis.contains(parentMap.get(node)))
            {
                q.add(parentMap.get(node));
                vis.add(parentMap.get(node));
            }

            }
        }
        List<Integer> ansList = new ArrayList<>();
         while(!q.isEmpty())
         {
             ansList.add(q.remove().val);
         }
         return ansList;
    }
    Map<TreeNode,TreeNode> fillParent(TreeNode root)
    {
        Queue<TreeNode>q =new LinkedList<>();
         q.add(root);
         Map<TreeNode,TreeNode> parent = new HashMap<>();
         parent.put(root,null);
         while(!q.isEmpty())
         {
             TreeNode node = q.peek();
              q.remove();
              if(node.left!=null)
              {
                  q.add(node.left);
                  parent.put(node.left,node);
              }
               if(node.right!=null)
              {
                  q.add(node.right);
                  parent.put(node.right,node);
              }

         }
         return parent;
    }
}
