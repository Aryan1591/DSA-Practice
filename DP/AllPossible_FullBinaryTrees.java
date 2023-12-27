package DP;

import java.util.ArrayList;
import java.util.List;

public class AllPossible_FullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int n) {
         List<TreeNode>ans=new ArrayList<>();
        if(n%2==0)
        {
            return ans;
        }
        if(n==1)
        {
            ans.add(new TreeNode(0));
            return ans;
        }
        for(int i=1;i<n;i++)
        {
           List<TreeNode>left_list=allPossibleFBT(i);
           List<TreeNode>right_list=allPossibleFBT(n-i-1);
             for(int j=0;j<left_list.size();j++)
             {
                 for(int k=0;k<right_list.size();k++)
                 {
                     TreeNode root=new TreeNode(0);
                       root.left=left_list.get(j);
                       root.right=right_list.get(k);
                        ans.add(root);
                 }
             }
        }
         return ans;

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
