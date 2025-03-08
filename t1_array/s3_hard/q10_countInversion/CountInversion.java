package t1_array.s3_hard.q10_countInversion;

import java.util.ArrayList;
import java.util.List;

class Solution {

    static void merge(int[] arr, int start, int mid, int end) {
        List<Integer> result = new ArrayList<>();
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                result.add(arr[i]);
                i++;
            } else {
                result.add(arr[j]);
                j++;
            }
        }
        while (i <= mid) {
            result.add(arr[i]);
            i++;

        }

        while (j <= end) {
            result.add(arr[j]);
            j++;
        }

        for (int j2 = 0; j2 < result.size(); j2++) {
            arr[start + j2] = result.get(j2);
        }
    }

    static int countInversion(int[] arr, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int count = 0;
        while (i <= mid) {
            while (j <= end && arr[i] > arr[j])
                j++;
            count += j - mid - 1;
            // count += mid - i + 1;
            i++;
        }
        return count;
    }

    static int mergeSort(int[] arr, int start, int end) {
        int count = 0;
        if (start >= end) {
            return count;
        }
        int mid = (int) Math.floor((start + end) / 2);
        count += mergeSort(arr, start, mid);
        count += mergeSort(arr, mid + 1, end);
        count += countInversion(arr, start, mid, end);
        merge(arr, start, mid, end);
        return count;
    }

    static int inversionCount(int arr[]) {
        int ans = 0;
        int start = 0, end = arr.length - 1;
        ans = mergeSort(arr, start, end);
        return ans;
    }
}

public class CountInversion {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 4, 5, 6 };
        Solution.inversionCount(arr);

    }
}
