package t2_binarySearch.s2_medium.q5_findTargetIndicesAfterSortingArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int findFirst(int[] nums, int target) {
        int ans = -1;
        int n = nums.length, i = 0, j = n - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int current = nums[mid];
            if (current >= target) {
                if (current == target)
                    ans = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return ans;
    }

    private int findLast(int[] nums, int target) {
        int ans = -1;
        int n = nums.length, i = 0, j = n - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int current = nums[mid];
            if (current <= target) {
                if (current == target)
                    ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<Integer>();
        Arrays.sort(nums);
        int first = findFirst(nums, target);
        int last = findLast(nums, target);
        if (first == -1)
            return ans;
        for (int i = first; i <= last; i++) {
            ans.add(i);
        }
        return ans;
    }
}

public class FindTargetIndicesAfterSortingArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1, 2, 5, 2, 3 };
        int target = 4;
        solution.targetIndices(nums, target);
    }
}
