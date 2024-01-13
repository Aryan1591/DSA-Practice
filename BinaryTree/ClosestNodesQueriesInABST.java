package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class ClosestNodesQueriesInABST {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
     List<List<Integer>>ans=new ArrayList<>();
         ArrayList<Integer>list=new ArrayList<>();
         if(root==null)return ans;
         solve(root,list);
        int n=queries.size();
          for(int i=0;i<n;i++)
          {
              int val=queries.get(i);
               int ans1=-1;
                int low=0;
               int high=list.size()-1;
                 while(low<=high)
                 {
                     int mid=low+(high-low)/2;
                      if(list.get(mid)==val)
                      {
                          ans1=val;
                            break;
                      }
                     else if(list.get(mid)>val)
                     {
                        high=mid-1;
                     }
                     else {
                         ans1=list.get(mid);
                           low=mid+1;
                     }
                 }
                 int ans2=-1;
                   low=0;
                  high=list.size()-1;
                  while(low<=high)
                  {
                      int mid=low+(high-low)/2;
                       if(list.get(mid)==val)
                       {
                           ans2=val;
                             break;
                       }
                      else if(list.get(mid)>val){
                           ans2=list.get(mid);
                            high=mid-1;
                      }
                      else {
                          low=mid+1;
                      }
                  }
              ArrayList<Integer>cur=new ArrayList<>();
                   
                cur.add(ans1);
                cur.add(ans2);
              
               ans.add(cur);
          }
          return ans;
        
    }
    static void solve(TreeNode root,ArrayList<Integer>list)
    {
       if(root==null)return;
         solve(root.left,list);
          list.add(root.val);
         solve(root.right,list);
    }
}
