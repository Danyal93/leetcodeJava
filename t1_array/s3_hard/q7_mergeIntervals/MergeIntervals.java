package t1_array.s3_hard.q7_mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] temp = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (temp[1] >= curr[0]) {
                temp[1] = Math.max(temp[1], curr[1]);
            } else {
                ans.add(temp);
                temp = intervals[i];
            }
        }
        ans.add(temp);
        return ans.toArray( new int[ans.size()][]);
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        solution.merge(intervals);
    }
}
