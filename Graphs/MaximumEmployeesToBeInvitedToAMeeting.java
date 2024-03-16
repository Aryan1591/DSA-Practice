package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumEmployeesToBeInvitedToAMeeting {
     public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            int nei = favorite[i];
            indegree[nei]++;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                vis[i] = true;
                q.add(i);
            }
        }
        int dp[] = new int[n];
        while (!q.isEmpty()) {
            int node = q.remove();
            int nei = favorite[node];
            dp[nei] = Math.max(dp[nei], 1 + dp[node]);
            indegree[nei]--;
            if (indegree[nei] == 0) {
                vis[nei] = true;
                q.add(nei);
            }
        }
        int cycleLengthWithGreaterThan2 = 0;
        int cycleLengthEqualTo2 = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int cycleLength = 0;
                int node = i;
                while (!vis[node]) {
                    cycleLength++;
                    vis[node] = true;
                    node = favorite[node];
                }
                if (cycleLength == 2) {
                    cycleLengthEqualTo2 += 2 + dp[i] + dp[favorite[i]];
                } else {
                    cycleLengthWithGreaterThan2 = Math.max(cycleLengthWithGreaterThan2, cycleLength);
                }
            }
        }
        return Math.max(cycleLengthWithGreaterThan2, cycleLengthEqualTo2);
    }
}
