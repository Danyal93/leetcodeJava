package t2_binarySearch.s2_medium.q3_specialArrayWithXElementsGreaterThanEqualX;

import java.util.Arrays;

class Solution {
    private int ceil(int[] nums, int x) {
        int result = -1;
        int n = nums.length, i = 0, j = n - 1;
        while (i <= j) {
            int mid = (int) Math.floor((i + j) / 2);
            int current = nums[mid];
            if (current >= x) {
                result = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }

        }
        return result;
    }

    public int specialArray(int[] nums) {
        int ans = -1;
        Arrays.sort(nums);
        int n = nums.length;
        // for (int i = 1; i <= nums.length; i++) {
        //     int c = ceil(nums, i);
        //     if (n - c == i) {
        //         ans = i;
        //         break;
        //     }
        // }
        int i = 0, j = n;
        while (i <= j) {
            int mid = (int) Math.floor((i + j) / 2);
            int c = ceil(nums, mid);
            int current = n - c;
            if (current == mid) {
                ans = mid;
                break;
            } else if (current < mid) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }

        }
        return ans;
    }
}

public class SpecialArrayWithXElementsGreaterThanEqualX {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 3, 5 };
        solution.specialArray(nums);
    }
}
