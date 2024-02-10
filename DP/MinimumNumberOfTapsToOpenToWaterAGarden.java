package DP;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class MinimumNumberOfTapsToOpenToWaterAGarden {
    public int minTaps(int n, int[] ranges) {
        //Map<Pair,Integer>dp=new HashMap<>();
        // int ans= solve(0,0,n,ranges,dp);
        // return ans>=(int)1e7 ? -1 : ans;
        return minTapsReq( n, ranges);
    }
    int minTapsReq(int n,int ranges[])
    {
         int dp[]=new int[n+1];
         Arrays.fill(dp,(int)1e7);
         // let dp[i] represents min number of taps required to be opened to water from 0 to i
        dp[0]=0;
         for(int i=0;i<=n;i++)
         {
             
              int left=Math.max(i-ranges[i],0);
              int right=Math.min(n,i+ranges[i]);
              for(int j=left;j<=right;j++)
              {
                dp[j]=Math.min(dp[j],1+dp[left]);
              }
         }
         
         return dp[n]==(int)1e7 ? -1 : dp[n];

    }
    int solve(int index,int cover,int n, int r[], Map<Pair,Integer>dp)
    {
         if(cover>=n)
          return 0;
        if(index==n+1)
          return (int)1e7;
         Pair p= new Pair(index,cover);
         if(dp.containsKey(p))
          return dp.get(p);
        int exclude = solve(index+1,cover,n,r,dp);
        int include = (int)1e7;
        if(index-r[index]<=cover)
         include = 1+solve(index+1,Math.max(cover,index+r[index]),n,r,dp);
         dp.put(p, Math.min(include,exclude));
        return Math.min(include,exclude);   
    }
}
class Pair {
    int index;
    int cover;
    
    Pair(int index, int cover) {
        this.index = index;
        this.cover = cover;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Pair pair = (Pair) obj;
        return index == pair.index && cover == pair.cover;
    }

    @Override
    public int hashCode() {
        return Objects.hash(index, cover);
    }
}
