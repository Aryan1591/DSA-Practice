package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;



public class AmountOfBTToBeInfected {
    public int amountOfTime(TreeNode root, int start) {
        
        Map<Integer,List<Integer>> tree = fillMap(root);
        Queue<int[]>q = new LinkedList<>();
        q.add(new int[]{start,-1});
        int time = 0;
         while(!q.isEmpty())
         {
             int size = q.size();
              for(int i=0;i<size;i++)
              {
                  int a[]= q.remove();
                  for(Integer x:tree.get(a[0]))
                  {
                      if(x==a[1])continue;
                      q.add(new int[]{x,a[0]});
                  }
              }
              time++;
         }
         return time-1;
    }
      Map<Integer,List<Integer>> fillMap(TreeNode root)
    {
        Map<Integer,List<Integer>>tree = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        tree.put(root.val,new ArrayList<>());
        while(!q.isEmpty())
        {
            TreeNode node = q.peek();
            q.remove();
             if(node.left != null)
             {
                 q.add(node.left);
                 tree.get(node.val).add(node.left.val);
                 if(!tree.containsKey(node.left.val))
                  tree.put(node.left.val,new ArrayList<>());
                  tree.get(node.left.val).add(node.val);
             }
              if(node.right != null)
             {
                 q.add(node.right);
                 tree.get(node.val).add(node.right.val);
                 if(!tree.containsKey(node.right.val))
                  tree.put(node.right.val,new ArrayList<>());
                  tree.get(node.right.val).add(node.val);
             }
        }
        return tree;
    }
}
class TreeNode {
     int val;
   TreeNode left;
   TreeNode right;
   TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
       this.left = left;
         this.right = right;
     }
 }
