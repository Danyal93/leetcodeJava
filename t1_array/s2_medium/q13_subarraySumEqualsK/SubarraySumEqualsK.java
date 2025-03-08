package t1_array.s2_medium.q13_subarraySumEqualsK;

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr += nums[i];
            if (map.containsKey(curr - k)) {
                ans += map.get(curr - k);
            }
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return ans;
    }
}

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 1, 1 };
        int k = 2;
        solution.subarraySum(nums, k);
    }
}
