package PriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsIII {
    public int mostBooked(int n, int[][] meetings) {
        int room[]=new int[n];
        PriorityQueue<Integer>roomAvailable = new PriorityQueue<>();
        PriorityQueue<int[]> pair = new PriorityQueue<>(new PairComparator());
       Arrays.sort(meetings,(a,b)->a[0]-b[0]);
       for(int i=0;i<n;i++)
       {
           roomAvailable.add(i);
       }
       int mL = meetings.length;
       for(int i=0;i<mL;i++)
       {
            int start=meetings[i][0];
            int end=meetings[i][1];
             while(!pair.isEmpty() && pair.peek()[0]<=start)
            {
                roomAvailable.add(pair.remove()[1]);
            }
            if(!roomAvailable.isEmpty())
            {
                 int roomNum = roomAvailable.remove();
                 room[roomNum]++;
                 pair.add(new int[]{end,roomNum});
            }
            else 
            {
                 int[] p=pair.remove();
                 room[p[1]]++;
                 pair.add(new int[]{p[0]+end-start,p[1]});
            }
       }
       int maxCount=-1;
       int ans=0;
       for(int i=0;i<n;i++)
       {
           if(room[i]>maxCount)
           {
               maxCount=room[i];
               ans=i;
           }
       } 
       return ans;
    }
}
class PairComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        if (a[0] == b[0]) {
            return a[1] - b[1];
        }
        return a[0] - b[0];
    }
}