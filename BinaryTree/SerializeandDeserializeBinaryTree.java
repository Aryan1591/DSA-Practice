package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
         if(root==null)
              return "";
        Queue<TreeNode>q=new LinkedList<TreeNode>();
         StringBuilder res=new StringBuilder();
           q.add(root);
           while(!q.isEmpty())
           {
               TreeNode current=q.remove();
                if(current==null)
                {
                    res.append("n ");
                    continue;
                }
                res.append(current.val+" ");
                 q.add(current.left);
                 q.add(current.right);
           }
           return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
          if(data=="")
               return null;
          String val[]=data.split(" ");
          TreeNode root=new TreeNode(Integer.parseInt(val[0]));
          Queue<TreeNode>q=new LinkedList<TreeNode>();
           q.add(root);
           for(int i=1;i<val.length;i++)
           {
               TreeNode parent=q.remove();
                 if(!val[i].equals("n"))
                 {
                     TreeNode left=new TreeNode(Integer.parseInt(val[i]));
                      parent.left=left;
                       q.add(left);
                 }
                 if(!val[++i].equals("n"))
                 {
                     TreeNode right=new TreeNode(Integer.parseInt(val[i]));
                      parent.right=right;
                      q.add(right);
                 }
           }
        return root;
    }
}
