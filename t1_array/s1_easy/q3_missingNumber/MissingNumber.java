package t1_array.s1_easy.q3_missingNumber;

class Solution1 {
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
class Solution {
    public int missingNumber(int[] nums) {
        // IMPLEMENTED USING CYCLIC SORT
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 0 && nums[i] < n && nums[nums[i]] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        for (int i = 0; i < n; ++i)
            if (nums[i] != i)
                return i;

        return n;
    }
}

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        Solution solution = new Solution();
        solution.missingNumber(nums);
    }
}