package DP;

public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
         int dp[][]=new int[sLength+1][tLength+1];
          for(int i=0;i<=tLength;i++)
          {
              dp[0][i]=0;
          }
          for(int i=0;i<=sLength;i++)
          {
              dp[i][0]=1;
          }
          for(int i=1;i<=sLength;i++)
          {
              for(int j=1;j<=tLength;j++)
              {
                  if(s.charAt(i-1)==t.charAt(j-1))
                   dp[i][j]+=dp[i-1][j-1];
                  dp[i][j]+=dp[i-1][j]; 
              }
          }
          return dp[sLength][tLength];
        }
}
