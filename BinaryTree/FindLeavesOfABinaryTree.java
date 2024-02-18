package BinaryTree;

import java.util.ArrayList;
import java.util.List;
public class FindLeavesOfABinaryTree {
    public List<List<Integer>> findLeaves(Node root)
    {
        int height = findHeight(root);
        List<List<Integer>>ansList = new ArrayList<>();
        for(int i=0;i<=height;i++)
        {
            ansList.add(new ArrayList<>());
        }
        solve(root,ansList);
        return ansList;
    }
    int solve(Node root,List<List<Integer>>ansList)
    {
        if(root==null)
         return -1;
        if(isLeaf(root))
        {
           ansList.get(0).add(root.val);
           return 0;
        }
        int left= solve(root.left,ansList); 
        int right = solve(root.right,ansList);
        int maxLevel = Math.max(left,right)+1;
        ansList.get(maxLevel).add(root.val);
        return maxLevel;
    }
    boolean isLeaf(Node root)
    {
        return root.left==null && root.right==null;
    }
    int findHeight(Node root)
    {
        if(root==null)
         return 0;
        return 1+Math.max(findHeight(root.left),findHeight(root.right)); 
    }
}
