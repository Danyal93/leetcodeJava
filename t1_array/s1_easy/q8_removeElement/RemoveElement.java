package t1_array.s1_easy.q8_removeElement;

class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length, j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != val) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            } else {

            }
        }
        return j - 1;
    }
}

public class RemoveElement {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
        int val = 2;
        solution.removeElement(nums, val);
    }
}
