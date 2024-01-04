package TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea=0;
        int n= height.length;
        int start=0;
        int end=n-1;
         while(start<end)
         {
             maxArea=Math.max(maxArea,(Math.min(height[start],height[end])*(end-start)));
              if(height[start]<height[end])
                start++;
             else 
                end--;  
         }
         return maxArea;
     }
}
