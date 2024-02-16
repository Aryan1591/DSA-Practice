package DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinaryTreeWithFactors {
    public int numFactoredBinaryTrees(int[] arr) {
        int mod=(int)1e9+7;
        Arrays.sort(arr);
        int n=arr.length;
        long dp[]=new long[n];
        dp[0]=1L;
        Map<Integer,Integer>map=new HashMap<>();
         map.put(arr[0],0);
         for(int i=1;i<n;i++)
         {
             dp[i]=1L;
             for(int j=0;j<i;j++)
             {
                 if(arr[i]%arr[j]==0 && map.containsKey(arr[i]/arr[j]))
                 {
                      int first=arr[j];
                      int second=arr[i]/arr[j];
                      if(first==second)
                      {
                          dp[i]+=(dp[j]%mod * dp[j]%mod)%mod;
                          dp[i]=dp[i]%mod;
                      }
                      else 
                      {
                           int index=map.get(arr[i]/arr[j]);
                           dp[i]+=(dp[j]%mod * dp[index]%mod)%mod;
                           dp[i]=dp[i]%mod;
                      }
                 }
             }

             map.put(arr[i],i);
         }

         long ans=0L;
          for(Long x:dp)
          {
              ans=(ans%mod + x%mod)%mod;
          }
          return (int)ans;

    }
}
