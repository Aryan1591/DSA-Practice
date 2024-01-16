package Sorting;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int indices[] = new int[n];
        for(int i=0;i<n;i++)
        {
            ans.add(0);
            indices[i]=i;
        }
        mergeSort(0,n-1,nums,ans,indices);
        return ans;
    }
     void mergeSort(int start,int end,int nums[],List<Integer> ans,int ind[])
     {
          if(start>=end)return ;
          int mid=(start+end)/2;
          mergeSort(start,mid,nums,ans,ind);
          mergeSort(mid+1,end,nums,ans,ind);
          merge(start,mid,end,nums,ans,ind);
     }
     void merge(int start,int mid,int end,int nums[],List<Integer> ans,int ind[])
     {
          int i=start;
          int j=mid+1;
          List<Integer>sortedList=new ArrayList<>();
          while(i<=mid)
          {
              while(j<=end && nums[ind[j]]<nums[ind[i]])
              {
                  j++;
              }
              ans.set(ind[i],ans.get(ind[i])+(j-mid-1));
              i++;
          }
          i=start;
          j=mid+1;
           while(i<=mid && j<=end)
           {
               if(nums[ind[i]]>nums[ind[j]])
               {
                   sortedList.add(ind[j]);
                   j++;
               }
               else{
                   sortedList.add(ind[i]);
                   i++;
               }
           }
           while(i<=mid)
           {
               sortedList.add(ind[i]);
                   i++; 
           }
           while(j<=end)
           {
             sortedList.add(ind[j]);
                   j++;  
           }
           i=start;
           for(Integer x:sortedList)
           {
               ind[i]=x;
               i++;
           }
     } 
}
