package DP;

import java.util.Arrays;
import java.util.List;

public class MaximizeTheProfitAsSalesMan {
   public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        int size = offers.size();
        int a[][]=new int[size][3];
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<3;j++)
            {
                a[i][j]=offers.get(i).get(j);
            }
        }
        Arrays.sort(a,(c,d)->{
            if(c[1]==d[1])
            return c[0]-d[0];
            return c[1]-d[1];
        });
        int dp[]=new int[size];
   
        
        for(int i=0;i<size;i++)
        {
            int include=a[i][2];
            int low=0;
            int high=i-1;
             while(low<=high)
             {
                 int mid=low+(high-low)/2;
                 if(a[mid][1]<a[i][0])
                 {
                     include=Math.max(include,dp[mid]+a[i][2]);
                     low=mid+1;
                 }
                 else{
                     high=mid-1;
                 }
             }
             dp[i]=Math.max(include,(i-1)>=0 ? dp[i-1] : 0);
          
        }
        int ans=-1;
         for(Integer x: dp)
         ans=Math.max(ans,x);
         return ans;
    } 
}
