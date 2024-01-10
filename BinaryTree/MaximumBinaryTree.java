package BinaryTree;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return createTree(nums,0,nums.length-1);
    }
    TreeNode createTree(int nums[],int left,int right)
    {
         if(left>right)
          return null;
         if(left==right)return new TreeNode(nums[left]);
         int index = findMaxIndex(nums,left,right);
         TreeNode root=new TreeNode(nums[index]);
         root.left=createTree(nums,left,index-1);
         root.right=createTree(nums,index+1,right);
          return root; 
    }
    int findMaxIndex(int nums[],int l,int r)
    {
        int pos=-1;
        int max=Integer.MIN_VALUE;
        for(int i=l;i<=r;i++)
        {
           if(nums[i]>max)
           {
               max=nums[i];
               pos=i;
           }
        } 
        return pos;
    } 
}
