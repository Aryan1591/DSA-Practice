package BinaryTree;

public class ConstructBSTFromPreOrder {
    public TreeNode bstFromPreorder(int[] preorder) {
        return solve(0,preorder.length-1,preorder);
    }
    TreeNode solve(int s,int e,int pre[])
    {
         if(s>e)
          return null;

          if(s==e)
          {
              return  new TreeNode(pre[s]);
          }

         TreeNode root=new TreeNode(pre[s]);
          int point=e+1;
           for(int i=s+1;i<=e;i++)
           {
               if(pre[i]>pre[s])
               {
                   point=i;
                    break;
               }
           }
          root.left=solve(s+1,point-1,pre);
          root.right=solve(point,e,pre);
           return root;  
    }
}
