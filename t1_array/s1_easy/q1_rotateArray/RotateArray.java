package t1_array.s1_easy.q1_rotateArray;

class Solution {
    public static void reverse(int[] nums, int i, int j) {
        while (i <= j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums, 0, n - k - 1);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }
}

public class RotateArray {
    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;
        obj.rotate(nums, k);
    }
}
