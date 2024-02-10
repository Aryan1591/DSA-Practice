package DP;

import java.util.Arrays;

public class AllocateMailBoxes {
     public int minDistance(int[] houses, int k) {
        //always to better to place at median
        //consider each possibility and keep there 
        //[2,5,7,10] first keep at 2 and solve for [5,7,10] 
        // keep at [2,5]s median and solve for [7,10]
        int n= houses.length;
        int cost[][]=new int[n][n];
        Arrays.sort(houses);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                int median = (i+j)/2;
                int sum=0;
                 for(int z=i;z<=j;z++)
                 {
                     sum+=Math.abs(houses[z]-houses[median]);
                 }
                 cost[i][j]=sum;
            }
        }
        int dp[][]=new int[n][k+1];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        return solve(0,k,houses,dp,cost,n);    
        
    }
    int solve(int index, int k,int houses[],int dp[][],int cost[][],int n)
    {
        if(index==n)
        {
            if(k==0)
            return 0;
            return (int)1e7;
        }
        if(k==0)return (int)1e7;
        if(dp[index][k]!=-1)
         return dp[index][k];
          
        int ans=Integer.MAX_VALUE;  
        for(int i=index;i<n;i++)
        {
          ans=Math.min(ans,cost[index][i]+solve(i+1,k-1,houses,dp,cost,n));
        } 
        return dp[index][k]=ans;
    }
}
