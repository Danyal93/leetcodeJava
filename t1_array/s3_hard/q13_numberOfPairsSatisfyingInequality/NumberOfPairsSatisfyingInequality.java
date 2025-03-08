package t1_array.s3_hard.q13_numberOfPairsSatisfyingInequality;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public long countPair(int[] diffArray, int start, int mid, int end, int diff) {
        long count = 0;

        int i = start;
        int j = mid + 1;
        while (j <= end) {
            while (i <= mid && diffArray[i] <= diffArray[j] + diff)
                i++;
            j++;
            count += (i - start);
        }
        return count;
    }

    public void merge(int[] diffArray, int start, int mid, int end, int diff) {
        int i = start;
        int j = mid + 1;
        List<Integer> sorted = new ArrayList<Integer>();

        while (i <= mid && j <= end) {
            if (diffArray[i] <= diffArray[j]) {
                sorted.add(diffArray[i]);
                i++;
            } else {
                sorted.add(diffArray[j]);
                j++;
            }
        }

        while (i <= mid) {
            sorted.add(diffArray[i]);
            i++;
        }
        while (j <= end) {
            sorted.add(diffArray[j]);
            j++;
        }
        for (int k = 0; k < sorted.size(); k++) {
            diffArray[start + k] = sorted.get(k);
        }
    }

    public long mergeSort(int[] diffArray, int start, int end, int diff) {
        long count = 0;
        if (start >= end)
            return count;
        int mid = (int) Math.floor((start + end) / 2);
        count += mergeSort(diffArray, start, mid, diff);
        count += mergeSort(diffArray, mid + 1, end, diff);
        count += countPair(diffArray, start, mid, end, diff);
        merge(diffArray, start, mid, end, diff);
        return count;
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        // nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
        // nums1[i] - nums2[i] <= nums1[j] - nums2[j] + diff.
        long ans = 0;
        int[] diffArray = new int[nums1.length];
        for (int i = 0; i < diffArray.length; i++) {
            diffArray[i] = nums1[i] - nums2[i];
        }
        int start = 0, end = nums1.length - 1;
        ans = mergeSort(diffArray, start, end, diff);
        return ans;
    }
}

public class NumberOfPairsSatisfyingInequality {
    public static void main(String[] args) {

        Solution solution = new Solution();
        int[] nums1 = { 3, 2, 5 };
        int[] nums2 = { 2, 2, 1 };
        int diff = 1;
        solution.numberOfPairs(nums1, nums2, diff);
    }
}
