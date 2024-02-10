package BinarySearch;

public class FindFirstAndLastPositionOfAnElementInASortedArray {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int pos=lowerbound(nums,target);
          if(pos==n || nums[pos]!=target)
          {
              return new int[]{-1,-1};
          }
          
          int ub=upperbound(nums,target);
           return new int[]{pos,ub-1};
      }
    int upperbound(int nums[],int target)
    {
        int n=nums.length;
         int ans=n;
         int low=0;
         int high=n-1;  
         while(low<=high)
         {
             int mid=low+(high-low)/2;
             if(nums[mid]>target)
             {
                 ans=mid;
                 high=mid-1;
             }
             else 
             {
                 low=mid+1;
             }
         }
         return ans;
    }
    int lowerbound(int nums[],int target)
    {
        int n=nums.length;
         int ans=n;
         int low=0;
         int high=n-1;
          while(low<=high)
          {
              int mid=low+(high-low)/2;
               if(nums[mid]>=target)
               {
                   ans=mid;
                   high=mid-1;
               }
               else 
               {
                   low=mid+1;
               }
          }
          return ans;
    }
}
