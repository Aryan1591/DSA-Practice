package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NumberWithRepeatedDigits {
      public int numDupDigitsAtMostN(int n) {
        List<Integer> list=new ArrayList<>();
         int temp=n;
          while(temp>0)
          {
              list.add(temp%10);
               temp/=10;
          }
          int size = list.size();
          Collections.reverse(list);
          int dp[][][][]= new int[size][2][1<<10][2];
          for(int i=0;i<size;i++)
          {
              for(int j=0;j<2;j++)
              {
                  for(int k=0;k<(1<<10);k++)
                  {
                      Arrays.fill(dp[i][j][k],-1);
                  }
              }
          }
          return findNums(0,1,0,0,dp,list,size);
          
    }
    int findNums(int index,int flag,int mask,int duplicate,int dp[][][][],List<Integer>list,int size)
    {
        if(index==size)
        {
            return duplicate == 1 ? 1 : 0;
        }
        if(dp[index][flag][mask][duplicate]!=-1)
         return dp[index][flag][mask][duplicate];
        int limit=9;
        if(flag==1)
         limit = list.get(index);
         int ans=0;
        for(int i=0;i<=limit;i++)
        {
            int nF=flag;
            if(i<limit && flag==1)
             nF=0;
            if(mask==0 && i==0)
            {
               ans+=findNums(index+1,nF,mask,duplicate,dp,list,size);
            }
            else{
                int newDuplicate=duplicate;
                if((mask & (1<<i))>0)
                 newDuplicate=1;
               ans+=findNums(index+1,nF,mask | (1<<i),newDuplicate,dp,list,size);  
            }
        }
        return dp[index][flag][mask][duplicate]=ans;  
    }
}
