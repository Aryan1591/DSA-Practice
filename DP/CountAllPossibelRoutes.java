package DP;

import java.util.Arrays;

public class CountAllPossibelRoutes {
    int mod =(int)1e9+7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n=locations.length;
        long dp[][]=new long[n][fuel+1];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1L);
        }
        return (int)solve(start,finish,fuel,locations,dp,n);
    }
    long solve(int currentIndex,int finish,int fuel,int loc[],long dp[][],int n)
    {
         if(fuel<0)
          return 0L;
         if(dp[currentIndex][fuel]!=-1)
          return dp[currentIndex][fuel];
         long ans=0L;
            if(currentIndex==finish)
            ans++;
          for(int i=0;i<n;i++)
          {
              if(i==currentIndex)continue;
              ans=(ans%mod + solve(i,finish,fuel- Math.abs(loc[i]-loc[currentIndex]),loc,dp,n)%mod)%mod;
          }
          return dp[currentIndex][fuel] = ans;   
    }
}
