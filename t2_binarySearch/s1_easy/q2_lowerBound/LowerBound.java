package t2_binarySearch.s1_easy.q2_lowerBound;

class Solution {
    static int findFloor(int[] arr, int k) {
        int ans = -1;
        int i = 0, n = arr.length, j = n - 1;
        while (i <= j) {
            int mid = (int) Math.floor((i + j) / 2);
            int current = arr[mid];
            if (current <= k) {
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }
}

public class LowerBound {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 8, 10, 11, 12, 19 };
        int k = 5;
        Solution.findFloor(arr, k);
    }
}
