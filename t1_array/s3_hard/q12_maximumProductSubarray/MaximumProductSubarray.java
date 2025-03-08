package t1_array.s3_hard.q12_maximumProductSubarray;

class Solution {
    public int maxProduct(int[] nums) {
        int ans = nums[0];
        long cProd = 1;
        for (int i = 0; i < nums.length; i++) {
            cProd *= nums[i];
            ans = (int) Math.max(ans, cProd);
            if (cProd == 0) {
                cProd = 1;
            }
        }
        cProd = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            cProd *= nums[i];
            ans = (int) Math.max(ans, cProd);
            if (cProd == 0) {
                cProd = 1;
            }
        }
        return ans;
    }
}

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2, 3, -2, 4 };
        solution.maxProduct(nums);
    }
}
