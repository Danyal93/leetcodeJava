package t2_binarySearch.s2_medium.q4_longestSubsequenceWithLimitedSum;

import java.util.Arrays;

class Solution {
    private int floor(int[] prefix, int target) {
        int result = -1;
        int i = 0, j = prefix.length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int current = prefix[mid];
            if (current <= target) {
                result = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return result + 1;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ans = new int[queries.length];
        int[] prefix = new int[nums.length];
        Arrays.sort(nums);
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            ans[i] = floor(prefix, queries[i]);
        }
        return ans;
    }
}

public class LongestSubsequenceWithLimitedSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 4, 5, 2, 1 };
        int[] queries = { 3, 10, 21 };
        solution.answerQueries(nums, queries);
    }
}
