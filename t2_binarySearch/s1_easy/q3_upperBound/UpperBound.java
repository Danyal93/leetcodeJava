package t2_binarySearch.s1_easy.q3_upperBound;

import java.util.Arrays;

class Solution {
    public int floor(int x, int[] arr) {
        int result = -1;
        int n = arr.length, i = 0, j = n - 1;
        while (i <= j) {
            int mid = (int) Math.floor((i + j) / 2);
            int current = arr[mid];
            if (current <= x) {
                result = arr[mid];
                i = mid + 1;
            } else {
                j = mid - 1;
            }

        }
        return result;
    }

    public int ceil(int x, int[] arr) {
        int result = -1;
        int n = arr.length, i = 0, j = n - 1;
        while (i <= j) {
            int mid = (int) Math.floor((i + j) / 2);
            int current = arr[mid];
            if (current >= x) {
                result = arr[mid];
                j = mid - 1;
            } else {
                i = mid + 1;
            }

        }
        return result;
    }

    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        Arrays.sort(arr);
        int[] ans = new int[2];
        ans[0] = floor(x, arr);
        ans[1] = ceil(x, arr);
        return ans;
    }
}

public class UpperBound {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int x = 7;
        int[] arr = { 5, 6, 8, 9, 6, 5, 5, 6 };
        solution.getFloorAndCeil(x, arr);
    }
}
