package DP;

public class EqualSubset {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
         for(Integer x:nums)
           sum+=x;
         if(sum%2!=0)return false;
         boolean dp[][]=new boolean[n][sum/2+1];
         for(int i=0;i<n;i++)
         {
             dp[i][0]=true;
         } 
         sum=sum/2;
         if(nums[0]<=sum)
         dp[0][nums[0]]=true; 
         for(int i=1;i<n;i++)
         {
             for(int j=0;j<=sum;j++)
             {
                 boolean first = dp[i-1][j];;
                 boolean second=false;
                 if(j-nums[i]>=0)
                 {
                     second=dp[i-1][j-nums[i]];
                 }
                 dp[i][j]= (first | second);
             }
         }
         return dp[n-1][sum];
    }
}
