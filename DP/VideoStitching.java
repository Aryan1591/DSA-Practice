package DP;

import java.util.Arrays;

public class VideoStitching {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips,(a,b)->{
            if(a[0]==b[0])
             return a[1]-b[1];
             else
              return a[0]-b[0];
        });
         int length=clips.length;
         int dp[][]=new int[length][time+1];
         for(int i=0;i<length;i++)
         {
             Arrays.fill(dp[i],-1);
         }
         int ans=solve(0,0,dp,clips,time);
          if(ans>=(int)1e4)
           return -1;
          return ans;
     }
    int solve(int index,int currentTime,int dp[][],int clips[][],int time)
    {
       if(index==clips.length)
        {
            if(currentTime>=time)
              return 0;
            return (int)1e4;
        }
        if(currentTime>=time)
         return 0;
        if(dp[index][currentTime]!=-1)
           return dp[index][currentTime];

        int exclude=solve(index+1,currentTime,dp,clips,time);
        int include=(int)1e4;
          if(currentTime>=clips[index][0]){
            include=1+solve(index+1,Math.max(currentTime,clips[index][1]),dp,clips,time);
         }
        return dp[index][currentTime]=Math.min(include,exclude);      
    }
}
