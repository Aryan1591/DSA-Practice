public class Maximum_Subarray {
    public int maxSubArray(int[] nums) {
        int maxSum=Integer.MIN_VALUE;
        int curSum=0;
        for(Integer x:nums){
            curSum=Math.max(x,curSum+x);
            maxSum=Math.max(maxSum,curSum);
            if(curSum<0)
            curSum=0;
        }
        return maxSum;
    }
}
