package DP;

public class PerfectSquares {
    public int numSquares(int n) {
        if(n==1 || n==2)
         return n;
          int dp[]=new int[n+1]; 
          dp[0]=0;
          dp[1]=1;
          dp[2]=2;
           for(int i=3;i<=n;i++)
           {
               dp[i]=Integer.MAX_VALUE;
               for(int j=1;j*j<=i;j++)
               {
                  dp[i]=Math.min(1+dp[i-j*j],dp[i]);
               }
           }
           return dp[n];
    }
}
