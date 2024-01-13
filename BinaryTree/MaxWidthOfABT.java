package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfABT {
     public int widthOfBinaryTree(TreeNode root) {
        int maxWidth=0;
        if(root==null)
         return maxWidth;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(root,0));
         while(!q.isEmpty())
         {
             int size=q.size();
             int min=-1;
             int max=-1;
             int smallest=q.peek().index;
              for(int i=0;i<size;i++)
              {
                  Pair p=q.peek();
                  q.remove();
                  if(i==0)
                  {
                      min=p.index;
                  }
                  if(i==size-1)
                  {
                      max=p.index;
                  }
                  if(p.node.left!=null)
                  {
                      q.add(new Pair(p.node.left,2*p.index+1-smallest));
                  }
                  if(p.node.right!=null)
                  {
                      q.add(new Pair(p.node.right,2*p.index+2-smallest));
                  }
              }
              maxWidth=Math.max(maxWidth,max-min+1);
         }
         return maxWidth; 
    }
}
class Pair
{
    TreeNode node;
    int index;
    Pair(TreeNode node,int index)
    {
        this.node=node;
        this.index=index;
    }
}
