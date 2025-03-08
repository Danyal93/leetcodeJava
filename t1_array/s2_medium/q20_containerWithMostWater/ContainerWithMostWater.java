package t1_array.s2_medium.q20_containerWithMostWater;

class Solution {
    public int maxArea(int[] height) {
        int ans = 0, n = height.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            ans = Math.max(ans, currentArea);
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return ans;
    }
}

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        solution.maxArea(height);
    }
}
