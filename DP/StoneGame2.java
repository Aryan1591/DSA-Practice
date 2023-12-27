package DP;

public class StoneGame2 {
    //player 0 Alice and player 1 Bob
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int dp[][][]=new int[2][n+1][n+1];
        for(int i=0;i<2;i++){
            for(int j=0;j<=n;j++){
                for(int k=0;k<=n;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        
        return solveForAlice(0,0,1,piles,dp,n);
    }
    int solveForAlice(int player,int index,int M,int piles[],int dp[][][],int n){
        if(index>=n)
         return 0;
        if(dp[player][index][M]!=-1)
          return dp[player][index][M];
        int stones=0;
        int result=(player==0)?-1:1000000;
        for(int x=1;x<=Math.min(2*M,n-index);x++){
            stones+=piles[index+x-1];
            if(player==0){
                result=Math.max(result,stones+solveForAlice(1,index+x,Math.max(M,x),piles,dp,n));
            }
            else{
                result=Math.min(result,solveForAlice(0,index+x,Math.max(M,x),piles,dp,n));
            }
        }
         return dp[player][index][M]=result;  
    }
}
