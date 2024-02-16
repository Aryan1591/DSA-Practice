package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountZeroRequestServers {
     public int[] countServers(int n, int[][] logs, int x, int[] queries) {
         Arrays.sort(logs,(a,b)->a[1]-b[1]);
         List<int[]>list=new ArrayList<>();
          int l=logs.length;
          int q=queries.length;
          int ans[]=new int[q];
          for(int i=0;i<q;i++)
          {
              list.add(new int[]{i,queries[i]});
          }
          Collections.sort(list,(a,b)->a[1]-b[1]);
          Map<Integer,Integer>serverCount = new HashMap<>();
          int start=0;
          int end=0;
          for(int i=0;i<q;i++)
          {
              while(end<l && list.get(i)[1]>=logs[end][1])
              {
                  serverCount.put(logs[end][0],serverCount.getOrDefault(logs[end][0],0)+1);
                  end++;
              }
              while(start<end && list.get(i)[1]-x>logs[start][1])
              {
                  serverCount.put(logs[start][0],serverCount.get(logs[start][0])-1);
                   if(serverCount.get(logs[start][0])==0)
                    serverCount.remove(logs[start][0]);
                  start++;
              }
             ans[list.get(i)[0]]=n-serverCount.size();
          }
          return ans;
    }
}
