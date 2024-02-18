package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubTrees {
     public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode>ans=new ArrayList<>();
        Map<String,Integer>duplicate=new HashMap<>();
         solve(root,ans,duplicate);
         return ans;
    }
     String solve(TreeNode root,List<TreeNode>ans,Map<String,Integer>duplicate)
     {
         if(root==null)
         {
             return "null";
         }
         String main=String.valueOf(root.val);
         String left=solve(root.left,ans,duplicate);
         String right=solve(root.right,ans,duplicate);
         String total=main+","+left+","+right;
           if(duplicate.containsKey(total))
           {
               int val=duplicate.get(total);
               if(val==1)
               ans.add(root);
               duplicate.put(total,val+1);
           }
           else 
           {
               duplicate.put(total,1);
           }
           return total;
     }
}
