package t1_array.s1_easy.q4_findMaxConsecutiveOnes;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxOne = 0, currentOne = 0;
        for (int i = 0; i < nums.length; i++) {
            currentOne = nums[i] != 1 ? 0 : currentOne + 1;
            maxOne = Math.max(maxOne, currentOne);
        }
        return maxOne;
    }
}

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] { 1, 0, 1, 1, 0, 1 };
        int ans = solution.findMaxConsecutiveOnes(nums);
        System.out.println(ans);
    }
}
