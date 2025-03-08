package t1_array.s1_easy.q6_longestSubArrayWithSumK;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenOfLongestSubarr(int[] arr, int k) {
        // code here
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int ans = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - k)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }
            if (!map.containsKey(sum))
                map.put(sum, i);
        }
        return ans;
    }
}

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = { 10, 5, 2, 7, 1, 9 };
        int k = 15;
        solution.lenOfLongestSubarr(arr, k);
    }
}
