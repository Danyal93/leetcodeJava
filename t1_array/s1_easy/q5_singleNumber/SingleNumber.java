package t1_array.s1_easy.q5_singleNumber;

class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 4, 1, 2, 1, 2 };
        solution.singleNumber(nums);
    }
}
