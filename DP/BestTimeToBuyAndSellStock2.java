package DP;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
         int dp[][]=new int[n][2];
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<2;j++)
               {
                   dp[i][j]=-1;
               }
           }
           return tab(prices);
          
    }
    static int tab(int prices[])
    {
               int n=prices.length;
         int dp[][]=new int[n+1][2];
           for(int index=n-1;index>=0;index--)
           {
               for(int buy=0;buy<=1;buy++)
               {
                  int profit=0; 
                   if(buy==1) // can buy or dont buy
             {
               int buyit=-prices[index]+dp[index+1][0];
               int not_buy=0+dp[index+1][1];
               profit=Math.max(buyit,not_buy);
             }
             else {
                 int sell=prices[index]+dp[index+1][1];
                 int not_sell=0+dp[index+1][0];
                 profit=Math.max(profit,Math.max(sell,not_sell));
             }
              dp[index][buy]=profit;
               }
           }
           return dp[0][1];
    }
     static int solve(int index,int buy,int prices[],int dp[][])
     {
         if(index==prices.length)
           return 0;
           int profit=0;
           if(dp[index][buy]!=-1)
              return dp[index][buy];
             if(buy==1) // can buy or dont buy
             {
               int buyit=-prices[index]+solve(index+1,0,prices,dp);
               int not_buy=0+solve(index+1,1,prices,dp);
               profit=Math.max(buyit,not_buy);
             }
             else {
                 int sell=prices[index]+solve(index+1,1,prices,dp);
                 int not_sell=0+solve(index+1,0,prices,dp);
                 profit=Math.max(profit,Math.max(sell,not_sell));
             }
             return dp[index][buy]=profit;
     }
}
