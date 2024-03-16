package DP;

import java.util.Arrays;

public class PalindromePartitioningIII {
   public int palindromePartition(String s, int k) {
        int n=s.length();
         if(k==n)return 0;
         //dp[i][j] stores min op to make S{i,j} as palindrome 
         int dp[][]=new int[n][n];
         for(int i=n-1;i>=0;i--)
         {
             for(int j=i;j<n;j++)
             {
                 if(i==j)dp[i][j]=0;
                 else if(j==i+1){
                     if(s.charAt(i)!=s.charAt(j))
                      dp[i][j]=1;
                 }
                 else{
                     int op=0;
                     if(s.charAt(i)!=s.charAt(j))
                      op=1;
                     dp[i][j]=op+dp[i+1][j-1]; 
                 }
             }
         }
         int dp2[][]=new int[n][k+1];
         for(int i=0;i<n;i++)
          Arrays.fill(dp2[i],-1);
         return solve(0,k,s,dp,dp2,n); 
    }
    int solve(int index,int k,String s,int dp[][],int dp2[][],int len)
    {
        if(k==0 && index==len)
         return 0;
        if(k==0 || index==len) 
         return (int)1e6;
         if(dp2[index][k]!=-1)
          return dp2[index][k];
          int ans=(int)1e6;
        for(int i=index;i<len;i++)
        {
           ans=Math.min(ans,dp[index][i]+solve(i+1,k-1,s,dp,dp2,len)); 
        }
        return dp2[index][k]=ans;
    } 
}
