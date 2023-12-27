package DP;

import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp[][]=new int[n][2];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return maxProfit(0,1,dp,prices,fee,n);
    }
    int maxProfit(int index,int buy,int dp[][],int prices[],int fee,int n)
    {
        if(index>=n)
         return 0;
        if(dp[index][buy]!=-1)
         return dp[index][buy];
        int maxPrice=0;
         if(buy==1){
           maxPrice=Math.max(maxPrice,-prices[index]+maxProfit(index+1,0,dp,prices,fee,n));
           maxPrice=Math.max(maxPrice,maxProfit(index+1,1,dp,prices,fee,n)); 
         }
         else{
            maxPrice=Math.max(maxPrice,prices[index]-fee+maxProfit(index+1,1,dp,prices,fee,n));
            maxPrice=Math.max(maxPrice,maxProfit(index+1,0,dp,prices,fee,n));
         }
        return dp[index][buy]=maxPrice;   
    }
}
