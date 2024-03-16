package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MakeArrayStrictlyIncreasing {
     public int makeArrayIncreasing(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        List<Integer> list=new ArrayList<>();
        list.add(-1);
        for(Integer x:arr1)list.add(x);
        int n=list.size();
        List<Integer> list2 = new ArrayList<>();
        for(Integer x:arr2)list2.add(x);
        int m=list2.size();
        // let dp[index][arr_taken][prev_index] denotes min op required to arrange list1 strictly increasing 
        // given u have taken which array lastly at which index;
        int dp[][][]= new int[n][2][Math.max(n,m)+1];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<2;j++)
            Arrays.fill(dp[i][j],-1);
        }
        int ans= solve(1,0,0,dp,list,list2,n,m);
        return ans>=(int)1e6 ? -1 : ans;
    }
    int solve(int index, int choose, int prevIndex,int dp[][][],List<Integer>list1, List<Integer>list2, int n, int m)
    {
         if(index==n)
          return 0;
         if(dp[index][choose][prevIndex]!=-1)
          return dp[index][choose][prevIndex];
         int ans1=(int)1e7;
         int ans2=(int)1e7;
         int prevVal=-1;
         if(choose==0)
         prevVal = list1.get(prevIndex);
         else
         prevVal = list2.get(prevIndex); 
         if(list1.get(index)<=prevVal)
         {
            int indexAtSecondList = find(list2,m,prevVal);
            if(indexAtSecondList!=-1)
            ans1=1+solve(index+1,1,indexAtSecondList,dp,list1,list2,n,m);  
         }
         else{
            int indexAtSecondList = find(list2,m,prevVal);
            if(indexAtSecondList!=-1)
            ans1=1+solve(index+1,1,indexAtSecondList,dp,list1,list2,n,m); 
            ans2=0+solve(index+1,0,index,dp,list1,list2,n,m);
         }
         return dp[index][choose][prevIndex] = Math.min(ans1,ans2);  
    }
    int find(List<Integer> list, int m, int prevVal)
    {
        int index = -1;
         int low=0;
         int high=m-1;
          while(low<=high)
          {
            int mid=low+(high-low)/2;
            if(list.get(mid)>prevVal)
            {
                index=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
          }
          return index;
    }
}
