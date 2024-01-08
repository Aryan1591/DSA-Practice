package DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParallelCourses3 {
    class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>>adj=new ArrayList<>();
         for(int i=0;i<=n;i++)
          adj.add(new ArrayList<>());
          int indegree[]=new int[n+1];
         for(int[] x: relations )
         {
             int u=x[0];
             int v=x[1];
             adj.get(u).add(v);
             indegree[v]++;
         } 
         int dp[]=new int[n+1];
         Queue<Integer>q=new LinkedList<>();
         for(int i=1;i<=n;i++)
         {
            if(indegree[i]==0)
             q.add(i);
             dp[i]=time[i-1];
         }
         while(!q.isEmpty())
         {
             int currentNode = q.remove();
             for(Integer x:adj.get(currentNode))
             {
                 int newTime=dp[currentNode] + time[x-1];
                 dp[x]=Math.max(dp[x],newTime);
                 indegree[x]--;
                  if(indegree[x]==0)
                   q.add(x); 
             }
         }
         int ans=0;
          for(Integer x:dp)
           ans=Math.max(ans,x);
         return ans;  

    }
}
}
