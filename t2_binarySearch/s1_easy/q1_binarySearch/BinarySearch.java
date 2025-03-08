package t2_binarySearch.s1_easy.q1_binarySearch;

class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int i = 0, n = nums.length, j = n - 1;
        while (i <= j) {
            int mid = (int) Math.floor((i + j) / 2);
            int current = nums[mid];
            if (current == target) {
                ans = mid;
                break;
            } else if (current < target) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }
}

public class BinarySearch {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = -1;
        solution.search(nums, target);
    }
}
