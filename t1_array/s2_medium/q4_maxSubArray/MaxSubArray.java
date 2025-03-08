package t1_array.s2_medium.q4_maxSubArray;

class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0], current = 0;
        for (int i = 0; i < nums.length; i++) {
            current += nums[i];
            ans = Math.max(ans, current);
            if (current < 0) {
                current = 0;
            }
        }
        return ans;
    }
}

public class MaxSubArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        solution.maxSubArray(nums);
    }
}
