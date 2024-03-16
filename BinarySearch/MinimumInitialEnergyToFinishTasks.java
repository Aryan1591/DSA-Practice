package BinarySearch;

import java.util.Arrays;

public class MinimumInitialEnergyToFinishTasks {
    public int minimumEffort(int[][] tasks) {
        long sum=0L;
         for(int[] x:tasks)
         {
             sum+=x[1];
         }
         long low=1L;
         long high=sum;
         Arrays.sort(tasks,(a,b)->{
             
             return (b[1]-b[0])-(a[1]-a[0]); 
         });
         long ans=Long.MAX_VALUE;
         while(low<=high)
         {
            long mid=low+(high-low)/2;
             if(possible(mid,tasks))
            {
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
         }
         return (int)ans;
    }
    boolean possible(long energy,int[][] tasks)
    {
        for(int[] x:tasks)
        {
            if(energy<x[1])return false;
            if(energy-x[0]<0)return false;
            energy-=x[0];
        }
        return true;
    }
}
