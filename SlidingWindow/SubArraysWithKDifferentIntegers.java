package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubArraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        // exactly(k)= atmost(k) - atmost(k-1);

        return solve(k, nums) - solve(k - 1, nums);

    }

    int solve(int k, int nums[]) {
        int ans = 0;
        Map<Integer, Integer> h = new HashMap<>();
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (j < n) {
            if (!h.containsKey(nums[j])) {
                h.put(nums[j], 1);
            } else {
                h.put(nums[j], h.get(nums[j]) + 1);
            }

            while (h.size() > k) {
                if (h.get(nums[i]) == 1) {
                    h.remove(nums[i]);
                } else {
                    h.put(nums[i], h.get(nums[i]) - 1);
                }
                i++;
            }
            ans += (j - i + 1);
            j++;
        }
        return ans;
    }

}
