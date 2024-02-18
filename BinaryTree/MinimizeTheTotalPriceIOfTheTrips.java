package BinaryTree;

import java.util.ArrayList;

public class MinimizeTheTotalPriceIOfTheTrips {
      public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        ArrayList<ArrayList<Integer>>list=new ArrayList<>();
          for(int i=0;i<=n+1;i++)
          {
              list.add(new ArrayList<>());
          }
          int m=edges.length;
           for(int i=0;i<m;i++)
           {
               int u=edges[i][0];
               int v=edges[i][1];
                list.get(u).add(v);
                list.get(v).add(u);
           }
           int fre[]=new int[n];
           int trip_len=trips.length;
           boolean vis[]=new boolean[n];
            for(int i=0;i<trip_len;i++)
            {
                int start=trips[i][0];
                int end=trips[i][1];
                ArrayList<Integer>total=new ArrayList<>();
              //  Arrays.fill(vis,false);
                 dfs(start,end,list,fre,total,vis);
            }

            //root at 0  and use dp
             int dp[][]=new int[n][2];
              solve(0,-1,list,price,fre,dp);
               return Math.min(dp[0][0],dp[0][1]);
    }
    void solve(int node,int parent,ArrayList<ArrayList<Integer>>list,int price[],int fre[],int dp[][])
    {

         dp[node][0]=fre[node]*(price[node]/2);
         dp[node][1]=fre[node]*(price[node]);
           for(Integer x:list.get(node))
           {
               if(x==parent)continue;
                solve(x,node,list,price,fre,dp);
                dp[node][0]+=dp[x][1];
                dp[node][1]+=Math.min(dp[x][0],dp[x][1]);
           } 

    }
     void dfs(int node,int target, ArrayList<ArrayList<Integer>>list , int fre[] , ArrayList<Integer>total,boolean vis[])
     {
               if(node==target)
               {
                   int size=total.size();
                    for(int i=0;i<size;i++)
                    {
                        fre[total.get(i)]++;
                    }
                    fre[target]++;
                    return;
               }
               vis[node]=true;
                total.add(node);
                 for(Integer x: list.get(node))
                 {
                     if(!vis[x])
                     {
                         dfs(x,target,list,fre,total,vis);
                     }
                 }
                 total.remove(total.size()-1);
                 vis[node]=false;
     }
}
