public class Sort_Colors {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int low=0;
        int middle=0;
        int high=n-1;
         while(middle<=high){
             if(nums[middle]==0){
                 swap(low,middle,nums);
                 low++;
                 middle++;
             }
             else if(nums[middle]==1){
                 middle++;
             }
             else{
                 swap(middle,high,nums);
                 high--;
             }
         }
    }
    void swap(int pos1,int pos2,int nums[]){
        int temp=nums[pos1];
        nums[pos1]=nums[pos2];
        nums[pos2]=temp;
    }
}
