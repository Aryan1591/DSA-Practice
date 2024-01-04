package DP;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean dp[][]=new boolean[sLength+1][pLength+1];
        dp[0][0]=true;
        for(int i=1;i<=sLength;i++)
        {
            dp[i][0]=false;
        }
        for(int i=2;i<=pLength;i++)
        {
            if(p.charAt(i-1)=='*')
             dp[0][i]=dp[0][i-2];
        }
        for(int i=1;i<=sLength;i++)
        {
            for(int j=1;j<=pLength;j++)
            {
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')
                  dp[i][j]=dp[i-1][j-1];
                if(p.charAt(j-1)=='*' && j>1)
                {
                    if(p.charAt(j-2)==s.charAt(i-1) || p.charAt(j-2)=='.')
                    {
                        boolean first=dp[i][j-2];
                        boolean second=dp[i-1][j];
                        if(first || second)dp[i][j]=true;
                    }
                    else{
                        dp[i][j]=dp[i][j-2];
                    } 
                }  
            }
        }
        return dp[sLength][pLength];
    }
}
