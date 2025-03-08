package t1_array.s3_hard.q5_longestSubarrayWithZeroSum;

import java.util.HashMap;

class Solution {
    int maxLen(int arr[]) {
        // code here
        int ans = 0;
        int curr = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            if (map.containsKey(curr)) {
                ans = Math.max(ans, i - map.get(curr));
            } else
                map.put(curr, i);
        }
        return ans;
    }
}

public class LongestSubarrayWithZeroSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };
        solution.maxLen(arr);
    }
}
