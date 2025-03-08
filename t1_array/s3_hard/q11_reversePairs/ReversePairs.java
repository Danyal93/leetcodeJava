package t1_array.s3_hard.q11_reversePairs;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public void merge(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        List<Integer> sorted = new ArrayList<Integer>();

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                sorted.add(nums[i]);
                i++;
            } else {
                sorted.add(nums[j]);
                j++;
            }
        }

        while (i <= mid) {
            sorted.add(nums[i]);
            i++;
        }
        while (j <= end) {
            sorted.add(nums[j]);
            j++;
        }
        for (int k = 0; k < sorted.size(); k++) {
            nums[start + k] = sorted.get(k);
        }
    }

    int countReversePair(int[] nums, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int count = 0;
        while (i <= mid) {
            while (j <= end && nums[i] > (long) 2 * nums[j])
                j++;
            count += j - mid - 1;
            i++;
        }
        return count;
    }

    public int mergeSort(int[] nums, int start, int end) {
        int count = 0;
        if (start >= end) {
            return count;
        }
        int mid = (int) Math.floor((start + end) / 2);
        count += this.mergeSort(nums, start, mid);
        count += this.mergeSort(nums, mid + 1, end);
        count += this.countReversePair(nums, start, mid, end);
        merge(nums, start, mid, end);
        return count;
    }

    public int reversePairs(int[] nums) {
        int ans = 0;
        int start = 0;
        int end = nums.length - 1;
        ans = this.mergeSort(nums, start, end);
        return ans;
    }
}

public class ReversePairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 2147483647, 2147483647, 2147483647, 2147483647, 2147483647, 2147483647 };
        solution.reversePairs(nums);
    }
}
/*
 * 2, 4, 3
 * 2, 3, 4 1, 5
 * 
 */