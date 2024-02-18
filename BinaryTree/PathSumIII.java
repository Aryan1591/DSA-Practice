package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {
     public int pathSum(TreeNode root, int targetSum) {
        return findPaths(root,new ArrayList<>(),targetSum);
        
    }
    int findPaths(TreeNode root,List<Integer>nodeList,int target)
    {
        if(root==null)
         return 0;
        nodeList.add(root.val);
        int left=findPaths(root.left,nodeList,target);
        int right=findPaths(root.right,nodeList,target);
        long sum=0L;
        int count=0;
        for(int i=nodeList.size()-1;i>=0;i--)
        {
            sum+=nodeList.get(i);
            if(sum==target)
            count++;
        }
        nodeList.remove(nodeList.size()-1);
        return left+right+count;
    }

    //can also be solved using prefix sum
}
