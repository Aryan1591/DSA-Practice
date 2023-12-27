package DP;

public class Minimum_ASCII_Delete_Sum_For_TwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int len1=s1.length();
        int len2=s2.length();
         int dp[][]=new int[len1+1][len2+1];
          for(int i=0;i<=len1;i++)
          {
              for(int j=0;j<=len2;j++)
              {
                  dp[i][j]=-1;
              }
          }
          return solve(len1,len2,s1,s2,dp);
    }
    int solve(int first,int second,String s1,String s2,int dp[][])
    {
        if(first==0 && second==0){
            return 0;
        }
        if(first==0)
        {
     return dp[first][second]=(int)s2.charAt(second-1)+solve(first,second-1,s1,s2,dp);
        }
        if(second==0)
        {
    return dp[first][second]=(int)s1.charAt(first-1)+solve(first-1,second,s1,s2,dp);   
        }
        if(dp[first][second]!=-1)
          return dp[first][second];
        int ans=0;
         if(s1.charAt(first-1)==s2.charAt(second-1))
         {
             ans=0+solve(first-1,second-1,s1,s2,dp);
         }
         else {
             int one=(int)s2.charAt(second-1)+solve(first,second-1,s1,s2,dp);
             int two=(int)s1.charAt(first-1)+solve(first-1,second,s1,s2,dp);
              ans=Math.min(one,two);
         } 
          return dp[first][second]=ans;
    }
}
