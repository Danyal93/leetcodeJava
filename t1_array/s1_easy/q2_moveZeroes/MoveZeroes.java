package t1_array.s1_easy.q2_moveZeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int nonZeroPointer = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                int temp = nums[i];
                nums[i] = nums[nonZeroPointer];
                nums[nonZeroPointer] = temp;
                nonZeroPointer++;
            }
        }
        System.out.println(nums);
    }
}

public class MoveZeroes {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 0, 1, 0, 3, 12 };
        solution.moveZeroes(nums);
    }
}
