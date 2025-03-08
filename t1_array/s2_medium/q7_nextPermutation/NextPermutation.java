package t1_array.s2_medium.q7_nextPermutation;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = 0;
        int replace = n - 1;
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                pivot = i - 1;
                break;
            }
        }
        for (int j = pivot + 1; j < nums.length; j++) {
            if (nums[pivot] < nums[j]) {
                replace = j;
            }
        }

        int temp = nums[pivot];
        nums[pivot] = nums[replace];
        nums[replace] = temp;
        Arrays.sort(nums, pivot + 1, n);
    }
}

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 5, 1 };
        solution.nextPermutation(nums);
    }
}
