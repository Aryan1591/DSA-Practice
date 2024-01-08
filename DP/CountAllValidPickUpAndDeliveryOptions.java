package DP;

public class CountAllValidPickUpAndDeliveryOptions {
    int mod=(int)1e9+7;
    public int countOrders(int n) {
        long dp[][]=new long[n+1][n+1];
         for(int i=0;i<=n;i++)
         {
             for(int j=0;j<=n;j++)
             {
                 dp[i][j]=-1L;
             }
         }

         return (int)solve(0,0,dp,n);

    }
    long solve(int open,int close,long dp[][],int n)
    {
        if(close==n)
         return 1L;

        if(dp[open][close]!=-1)
          return dp[open][close];

        long ans=0L;
          if(open<n)
          {
               long cal=((n-open)%mod * (solve(open+1,close,dp,n)%mod))%mod;
               ans=(ans%mod + cal%mod)%mod;

          }

          if(close<open)
          {
               long cal=((open-close)%mod * (solve(open,close+1,dp,n)%mod))%mod;
                ans=(ans%mod + cal%mod)%mod;
          }

          return dp[open][close]=ans;
          

    }
}
