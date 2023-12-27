import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    public int[][] merge(int[][] intervals) {
        List<int[]>mergedList=new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
          if (a[0] == b[0]) return a[1] - b[1];
          return a[0] - b[0];
         });
        int len=intervals.length;
        mergedList.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i=1;i<len;i++){
            if(intervals[i][0]<=mergedList.get(mergedList.size()-1)[1])
            {
                int prev[]=mergedList.get(mergedList.size()-1);
                mergedList.remove(mergedList.size()-1);
                mergedList.add(new int[]{prev[0],Math.max(prev[1],intervals[i][1])});
            }
            else{
                mergedList.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
         return mergedList.toArray(new int[0][]); 
    }
}
