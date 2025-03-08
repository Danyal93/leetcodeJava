package t1_array.s2_medium.q2_sortColors;

class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeroPointer = 0;
        int twoPointer = n - 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[zeroPointer];
                nums[zeroPointer] = temp;
                zeroPointer++;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[twoPointer];
                nums[twoPointer] = temp;
                twoPointer--;
            }
        }
    }
}

public class SortColors {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortColors(new int[] { 2, 0, 2, 1, 1, 0 });
    }
}
