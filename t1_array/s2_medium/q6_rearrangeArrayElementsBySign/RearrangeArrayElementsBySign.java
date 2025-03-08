package t1_array.s2_medium.q6_rearrangeArrayElementsBySign;

class Solution {
    private int[] ans;
    private int pi;
    private int ni;

    private void appendPositiveValue(int value) {
        this.ans[this.pi] = value;
        this.pi +=2;
    }

    private void appendNegativeValue(int value) {
        this.ans[this.ni] = value;
        this.ni +=2;
    }

    public int[] rearrangeArray(int[] nums) {
        this.ans = new int[nums.length];
        this.pi = 0;
        this.ni = 1;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value >= 0)
                appendPositiveValue(value);
            else
                appendNegativeValue(value);
        }
        return this.ans;
    }
}

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int nums[] = { 3, 1, -2, -5, 2, -4 };
        solution.rearrangeArray(nums);
    }
}
