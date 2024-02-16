package SlidingWindow;

public class LongestSubArrayOf1AfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int i=0;
        int j=0;
        int n=nums.length;
        int zero=0;
        int ans=0;
      
         while(j<n)
         {
             if(nums[j]==0)
               zero++;

              while(zero>1 && i<j)
              {
                   if(nums[i]==0)
                   {
                       zero--;
                   }
                   i++;
              }
          
              ans=Math.max(ans,j-i);  
              j++;
         }
         return ans;
   }
}
