package SlidingWindow;

public class CountSubArraysWithFixedBounds {
    class Solution {
        public long countSubarrays(int[] nums, int minK, int maxK) {
            boolean min=false;
            boolean max=false;
             int minp=0;
             int maxp=0;
             int start=0;
             long ans=0L;
              for(int i=0;i<nums.length;i++)
              {
                  if(nums[i]>maxK || nums[i]<minK)
                  {
                        min=false;
                        max=false;
                        start=i+1;
                  }
                  if(nums[i]==minK)
                  {
                      min=true;
                      minp=i;
                  }
                  if(nums[i]==maxK)
                  {
                      max=true;
                      maxp=i;
                  }
                    if(min && max)
                    {
                        ans+=(Math.min(minp,maxp)-start)+1;
                    }
              }
              return ans;
              
        }
    }
}
