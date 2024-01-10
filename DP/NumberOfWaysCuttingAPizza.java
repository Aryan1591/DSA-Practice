package DP;

public class NumberOfWaysCuttingAPizza {
    int mod=(int)1e9+7;
    public int ways(String[] pizza, int k) {
        int n=pizza.length;
        int m=pizza[0].length();
        int aux[][]=new int[n+1][m+1];
        for(int i=n-1;i>=0;i--)
        {
            for(int j=m-1;j>=0;j--)
            {
    aux[i][j]=aux[i][j+1]+aux[i+1][j]-aux[i+1][j+1];
       if(pizza[i].charAt(j)=='A') aux[i][j]+=1;
            }
        }
        long dp[][][]=new long[n][m][k];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++){
                for(int x=0;x<k;x++)dp[i][j][x]=-1L;
            }
        }
        return (int)solve(0,0,k-1,dp,aux,n,m);
        
    }
    long solve(int r,int c,int cuts,long dp[][][],int aux[][],int n,int m)
    {
          if(aux[r][c]==0)return 0;
          if(cuts==0)return 1;
          if(dp[r][c][cuts]!=-1L)
            return dp[r][c][cuts];
          long ans=0L;
          for(int i=r+1;i<n;i++)
          {
              if(aux[r][c]-aux[i][c]>0) // I have apples
              {
                  ans=(ans%mod + solve(i,c,cuts-1,dp,aux,n,m)%mod)%mod;
              }
          }

          for(int i=c+1;i<m;i++)
          {
              if(aux[r][c]-aux[r][i]>0)
              {
                  ans=(ans%mod + solve(r,i,cuts-1,dp,aux,n,m)%mod)%mod;
              }
          }

          return dp[r][c][cuts]=ans;

    }    
}
