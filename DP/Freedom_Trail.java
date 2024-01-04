package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Freedom_Trail {
    public int findRotateSteps(String ring, String key) {
         int ringLength=ring.length();
         int keyLength = key.length();
         int dp[][]=new int[ringLength][keyLength];
         Map<Character,List<Integer>>pos=new HashMap<>();
          for(int i=0;i<ringLength;i++)
          {
              char c=ring.charAt(i);
              if(!pos.containsKey(c))
                 pos.put(c,new ArrayList<>());
               pos.get(c).add(i);
               Arrays.fill(dp[i],-1);
          }
          return minSteps(0,0,ring,key,dp,pos,ringLength,keyLength);
    }
    int minSteps(int rIndex,int kIndex,String ring,String key,int dp[][],   Map<Character,List<Integer>>pos,int rL,int kL)
    {
        if(kIndex==kL)
         return 0;
        if(dp[rIndex][kIndex]!=-1)
          return dp[rIndex][kIndex];  
        if(ring.charAt(rIndex)==key.charAt(kIndex))
           return dp[rIndex][kIndex]=1+minSteps(rIndex,kIndex+1,ring,key,dp,pos,rL,kL);

        List<Integer>all_pos=pos.get(key.charAt(kIndex));
        int cur_ans=Integer.MAX_VALUE;
        for(Integer positions: all_pos)
        {
    int distance=Math.min(Math.abs(positions-rIndex),rL-(Math.abs(positions-rIndex)));
cur_ans=Math.min(cur_ans,distance+minSteps(positions,kIndex,ring,key,dp,pos,rL,kL));
           
        }     
          return dp[rIndex][kIndex]=cur_ans;
    }
}
