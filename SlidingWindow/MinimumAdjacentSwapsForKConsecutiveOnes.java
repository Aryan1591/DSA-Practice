package SlidingWindow;

import java.util.ArrayList;
import java.util.List;

public class MinimumAdjacentSwapsForKConsecutiveOnes {
    public int minMoves(int[] nums, int k) {
        List<Integer> pos = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1)
                pos.add(i);
        }
        int size = pos.size();
        if (size == 0)
            return -1;
        if (k == 1)
            return 0;
        List<Long> pre = new ArrayList<>();
        long sum = 0L;
        for (Integer x : pos) {
            sum += x;
            pre.add(sum);
        }
        int start = 0;
        int end = 0;
        long ans = Long.MAX_VALUE;
        while (end < k - 1) {
            end++;
        }
        while (end < size) {
            int midIndex = start + (end - start) / 2;
            int midPositionElement = pos.get(midIndex);
            long left = midPositionElement * (midIndex - start + 1);
            long leftPreSum = pre.get(midIndex);
            if (start - 1 >= 0)
                leftPreSum -= pre.get(start - 1);
            left -= leftPreSum;
            int leftElements = (midIndex - start);
            long leftSum = getSum(leftElements);
            left -= leftSum;
            long right = pre.get(end) - pre.get(midIndex);
            right -= midPositionElement * (end - midIndex);
            int rightElements = (end - midIndex);
            long rightSum = getSum(rightElements);
            right -= rightSum;
            ans = Math.min(ans, left + right);
            start++;
            end++;
        }
        return (int) ans;
    }

    long getSum(int n) {
        return (long) (n * (n + 1)) / 2;
    }
}
