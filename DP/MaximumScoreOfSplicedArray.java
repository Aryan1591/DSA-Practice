package DP;

import java.util.Arrays;

public class MaximumScoreOfSplicedArray {
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        return Math.max(kadane(nums1,nums2),kadane(nums2,nums1));
    }
    int kadane(int a[],int b[])
    {
        int sum= Arrays.stream(a).sum();
        int maxi=0;
        int curSum=0;
        int n=a.length;
         for(int i=0;i<n;i++)
         {
            curSum=Math.max(0,curSum+b[i]-a[i]);
            maxi=Math.max(curSum,maxi);
         }
         return sum+maxi;
    }
}
