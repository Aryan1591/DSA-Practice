package BinaryTree;

public class LongestUnivaluePath {
    int ans=0;
    int maxPath=0;
    public int longestUnivaluePath(TreeNode root) {
         solve(root,-1);
          return ans;
    }
    int solve(TreeNode root,int parent_val)
    {
        if(root==null)return 0;
         int left=solve(root.left,root.val);
         int right=solve(root.right,root.val);
           ans=Math.max(ans,left+right);
           if(root.val!=parent_val)
             return 0;
            return 1+Math.max(left,right); 
    }
    int longestPath(TreeNode root)
    {
        if(root==null)
         return 0;
        int left=longestPath(root.left);
        int right=longestPath(root.right);
        int curPath=1;
        int maxPathFromCurrentNode=1;
         if(root.left!=null && root.left.val==root.val){
           curPath+=left;
           maxPathFromCurrentNode=Math.max(maxPathFromCurrentNode,1+left);
         }
         if(root.right!=null && root.right.val==root.val){
           curPath+=right;
           maxPathFromCurrentNode=Math.max(maxPathFromCurrentNode,1+right);
         }
          maxPath=Math.max(maxPath,curPath);
          return maxPathFromCurrentNode;
           
    }
}
