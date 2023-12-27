import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>>ans=new ArrayList<>();
        Arrays.sort(nums);
        int first=0;
        int n=nums.length;
        while(first<n-3){
            int second=first+1;
            while(second<n-2){
                long sum1=nums[first]+nums[second];
                int third=second+1;
                int fourth=n-1;
                 while(third<fourth){
                
                   long sum=0L;
                    sum+=nums[third];
                    sum+=nums[fourth];
                    sum+=sum1;
                    if(sum>target){
                        fourth--;
                    }
                    else if(sum<target){
                        third++;
                    }
                    else{
                        List<Integer>potential=new ArrayList<>();
                        potential.add(nums[first]);
                        potential.add(nums[second]);
                        potential.add(nums[third]);
                        potential.add(nums[fourth]);
                        ans.add(new ArrayList<>(potential));
                        while(third<fourth && nums[third]==potential.get(2))third++;
                        while(third<fourth && nums[fourth]==potential.get(3))fourth--;
                       
                    }
                   
                 }
                 
                 while(second<n-2 && nums[second]==nums[second+1])second++;
                 second++;
               
            }
            while(first<n-3 && nums[first]==nums[first+1])first++;
            first++;
          
        }
        return ans;
    }
}
