package BinaryTree;

public class ConvertBSTToGreaterTree {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        solve(root);
        return root;
    }
    void solve(TreeNode root)
    {
        if(root==null)return;
        solve(root.right);
        sum+=root.val;
        root.val=sum;
        solve(root.left);
    } 
}
