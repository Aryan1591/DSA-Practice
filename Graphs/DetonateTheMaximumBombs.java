package Graphs;

import java.util.ArrayList;
import java.util.HashSet;

public class DetonateTheMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        int n=bombs.length;
         ArrayList<ArrayList<Integer>>list=new ArrayList<>();
           for(int i=0;i<=n;i++)
           {
               list.add(new ArrayList<>());
           }
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                   if(i==j)continue;
                   if(check(bombs[i][0],bombs[i][1],bombs[j][0],bombs[j][1],bombs[i][2]))
                   {
                       list.get(i).add(j);
                      
                   }
               }
           }
           int ans=0;
            for(int i=0;i<n;i++)
             {
                ans=Math.max(ans, dfs(i,list,new HashSet<>()));
             }
             return ans;
    }

    boolean check(int x1, int y1, int x2, int y2,int r1)
    {
        if ((long)r1 * r1 >= (long)(x1 - x2) * (x1 - x2) + (long)(y1 - y2) * (y1 - y2)) {
                    return true;
                }
        return false;
    }
     int dfs(int node,ArrayList<ArrayList<Integer>>list,HashSet<Integer>set )
     {
        set.add(node);
        int count=1;
           for(Integer x:list.get(node))
           {
               if(!set.contains(x))
               {
                   count+=dfs(x,list,set);
               }
           }
         return count;
     }
}
