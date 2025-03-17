package t1_array.s3_hard.q14_countRangeSum;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/count-of-range-sum/solutions/1300388/merge-sort-solution-c/
class Solution {
    private void merge(long[] prefixSum, int start, int mid, int end, int lower, int upper) {
        int i = start, j = mid + 1;
        List<Long> result = new ArrayList<>();
        while (i <= mid && j <= end) {
            if (prefixSum[i] < prefixSum[j]) {
                result.add(prefixSum[i++]);
            } else {
                result.add(prefixSum[j++]);
            }
        }
        while (i <= mid) {
            result.add(prefixSum[i++]);
        }
        while (j <= end) {
            result.add(prefixSum[j++]);
        }
        for (int k = 0; k < result.size(); k++) {
            prefixSum[start + k] = result.get(k);
        }
    }

    private int countRange(long[] prefixSum, int start, int mid, int end, int lower, int upper) {
        int i = start, j = mid + 1, k = mid + 1, count = 0;
        while (i <= mid) {
            while (j <= end && prefixSum[i] > prefixSum[j] - lower) // since "j" is on the lesser side, therefore we increase "j" :- this pattern follows in all this kind of questions
                j++;
            while (k <= end && prefixSum[i] >= prefixSum[k] - upper) // since "k" is on the lesser side, therefore we increase "k" :- this pattern follows in all this kind of questions
                k++;

            count += k - j;
            i++;
        }
        return count;
    }

    private int mergeSort(long[] prefixSum, int start, int end, int lower, int upper) {
        int count = 0;
        if (start >= end)
            return count;
        int mid = (int) Math.floor((start + end) / 2);
        count += mergeSort(prefixSum, start, mid, lower, upper);
        count += mergeSort(prefixSum, mid + 1, end, lower, upper);
        count += countRange(prefixSum, start, mid, end, lower, upper);
        merge(prefixSum, start, mid, end, lower, upper);
        return count;
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        int start = 0;
        int end = nums.length;
        long[] prefixSum = new long[nums.length + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }
        int count = this.mergeSort(prefixSum, start, end, lower, upper);
        return count;
    }
}

public class CountRangeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { -3, 1, 2, -2, 2, -1 };
        int lower = -3;
        int upper = -1;
        solution.countRangeSum(nums, lower, upper);
    }
}
