package t1_array.s2_medium.q9_longestConsecutiveSequence;

import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i]-1)){
                continue;
            }
            int j = 0;
            while(set.contains(nums[i]+j)){
                j++;
            }
            ans = Math.max(ans, j);
        }
        return ans;
    }
}

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        solution.longestConsecutive(nums);
    }
}
