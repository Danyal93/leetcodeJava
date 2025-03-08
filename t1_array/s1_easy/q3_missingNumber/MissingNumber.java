package t1_array.s1_easy.q3_missingNumber;

class Solution {
    public int missingNumber(int[] nums) {
        int xor1 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            xor1 = xor1 ^ i;
        }
        return xor1;
    }
}

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        Solution solution = new Solution();
        solution.missingNumber(nums);
    }
}