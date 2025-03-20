package t2_binarySearch.s1_easy.q4_searchInsertPosition;

class Solution {
    public int ceil(int[] arr, int x) {
        int n = arr.length;
        int i = 0, j = n - 1;
        int ans = -1;
        while (i <= j) {
            int mid = (int) Math.floor((i + j) / 2);
            int ele = arr[mid];
            if (ele >= x) {
                ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }

    public int searchInsert(int[] nums, int target) {
        int c = ceil(nums, target);
        int n = nums.length;
        if (c == -1) {
            return n;
        }
        return c;
    }
}

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 3, 5, 6 };
        int target = 5;
        solution.searchInsert(nums, target);
    }
}
