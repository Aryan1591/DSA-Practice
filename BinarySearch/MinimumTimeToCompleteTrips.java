package BinarySearch;

public class MinimumTimeToCompleteTrips {
    public long minimumTime(int[] time, int totalTrips) {
        long maxi=-1L;
        for(Integer x:time)
        {
            maxi=Math.max(maxi,x);
        }
        long low=1L;
        long high=maxi*totalTrips*1L; // At max we need only this much
        long minTime=high;
        while(low<=high)
        {
            long currentTime = low+(high-low)/2;
            if(possible(time,totalTrips,currentTime))
            {
                minTime=Math.min(minTime,currentTime);
                high=currentTime-1;
            }
            else{
                low=currentTime+1;
            }
        }
        return minTime;
    }
    boolean possible(int time[],int totalTrips,long currentTime)
    {
        long tripsPossible=0L;
        for(Integer x:time)
        {
            tripsPossible+=(currentTime)/x; 
        }
        if(tripsPossible>=totalTrips)
         return true;
        return false; 
    }
}
