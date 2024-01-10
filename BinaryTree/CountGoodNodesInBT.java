package BinaryTree;

public class CountGoodNodesInBT {
    int goodCount=0;
    public int goodNodes(TreeNode root) {
        count(root,Integer.MIN_VALUE);
        return goodCount;
    }
    void count(TreeNode root,int maxi)
    {
         if(root==null)return;
         if(root.val>=maxi)goodCount++;
         count(root.left,Math.max(maxi,root.val));
         count(root.right,Math.max(maxi,root.val));
    }
}
