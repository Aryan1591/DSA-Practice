package DP;

public class Partition_Array_For_MaximumSum {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n+1];
         for(int i=0;i<=n;i++)
         {
             dp[i]=-1;
         }
         return solve(0,k,arr,dp);
    }
    int solve(int index,int k,int a[],int dp[])
    {
        if(index>=a.length)
        {
            return 0;
        }
        if(dp[index]!=-1)
          return dp[index];
        int cur_max=Integer.MIN_VALUE;
        int max_element=-1;
        int size=a.length;
         for(int i=index;i<Math.min(size,index+k);i++)
         {
             max_element=Math.max(max_element,a[i]);
             int cur_ans=(max_element*(i-index+1))+solve(i+1,k,a,dp);
             cur_max=Math.max(cur_max,cur_ans);
         }
          return dp[index]=cur_max;
    }
}
