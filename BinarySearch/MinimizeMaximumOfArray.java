package BinarySearch;

public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        for(Integer x:nums)
        {
            maxi=Math.max(maxi,x);
            mini=Math.min(x,mini);
        }
        int low=mini;
        int high=maxi;
        int ans=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
             if(possible(nums,mid))
             {
                 ans=Math.min(ans,mid);
                 high=mid-1;
             }
             else{
                 low=mid+1;
             }
        }
        return ans;
    }
    boolean possible(int a[],int mid)
    { 
        int n=a.length;
     long[] temp = new long[n];
     for (int i = 0; i < n; i++) {
        temp[i] = a[i];
     }
       
        for(int i=n-1;i>0;i--)
        {
            if(temp[i]>mid)
            {
                temp[i-1]=temp[i-1]+(temp[i]-mid);

            }
        }
        if(temp[0]>mid)
         return false;
        return true;
    }
}
