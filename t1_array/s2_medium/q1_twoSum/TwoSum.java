package t1_array.s2_medium.q1_twoSum;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = { 0, 0 };
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.twoSum(new int[] { 2, 7, 11, 15 }, 9);
    }
}
