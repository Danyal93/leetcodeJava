package t2_binarySearch.s2_medium.q1_firstAndLastPositionOfElementInSortedArray;

class Solution {
    public int findLast(int target, int[] nums) {
        int result = -1;
        int n = nums.length, i = 0, j = n - 1;
        while (i <= j) {
            int mid = (int) Math.floor((i + j) / 2);
            int current = nums[mid];
            if (current <= target) {
                if (current == target)
                    result = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }

        }
        return result;
    }

    public int findFirst(int target, int[] nums) {
        int result = -1;
        int n = nums.length, i = 0, j = n - 1;
        while (i <= j) {
            int mid = (int) Math.floor((i + j) / 2);
            int current = nums[mid];
            if (current >= target) {
                if (current == target)
                    result = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }

        }
        return result;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[1] = findLast(target, nums);
        ans[0] = findFirst(target, nums);
        return ans;
    }
}

public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int target = 7;
        int[] nums = { 5, 6, 8, 9, 6, 5, 5, 6 };
        solution.searchRange(nums, target);
    }
}
