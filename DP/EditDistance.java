package DP;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int  m=word2.length();
         if(n==0)
           return m;
          if(m==0)
           return n; 
        int dp[][]=new int[n+1][m+1];
       
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0)
                {
                    dp[i][j]=j;
                    continue;
                }
                if(j==0)
                {
                    dp[i][j]=i;
                     continue;
                }
                if(word1.charAt(i-1)==word2.charAt(j-1))
                dp[i][j]=dp[i-1][j-1];
                else {
                    dp[i][j]=1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }

        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
