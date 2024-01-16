package TwoPointers;

public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int maxLength=0;
        int n=nums.length;
        int start=0;
        int end=0;
        int zero=0;
        while(end<n)
        {
            if(nums[end]==0)
              zero++;
            while(zero>k)
            {
                if(nums[start]==0)
                  zero--;
                start++;  
            }
            maxLength=Math.max(maxLength,end-start+1);  
            end++;
        }
        return maxLength;
    }
}
