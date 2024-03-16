package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class NumberOfGoodLeafNodePairs {
     int ans=0;
    public int countPairs(TreeNode root, int distance) {
        solve(root,distance);
        return ans;
    }
    List<Integer> solve(TreeNode root, int dis)
    {
        if(root==null)
        return new ArrayList<>();
        if(isLeaf(root))
        {
          List<Integer>list=new ArrayList<>();
          list.add(1);
          return list;
        }
        List<Integer>left= solve(root.left,dis);
         List<Integer>right= solve(root.right,dis);
        for(Integer x:left)
        {
            for(Integer y:right)
            {
                if(x+y <= dis)ans++;
            }
        }
        List<Integer>curLevl = new ArrayList<>();
        for(Integer x:left)curLevl.add(x+1);
        for(Integer y:right)curLevl.add(y+1);
         return curLevl;
        }
    boolean isLeaf(TreeNode root){
    return root.left==null && root.right==null; 
    }
}
