package t1_array.s1_easy.q7_relativeSortArray;

import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int[] relativeSortArrayOptimised(int[] arr1, int[] arr2) {
        int[] cnt = new int[1001];
        for (int n : arr1)
            cnt[n]++;
        int i = 0;
        for (int n : arr2) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        for (int n = 0; n < cnt.length; n++) {
            while (cnt[n]-- > 0) {
                arr1[i++] = n;
            }
        }
        return arr1;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int i = 0; i < arr1.length; i++) {
            int curr = arr1[i];
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        int i = 0, j = 0;
        while (i < arr2.length) {
            int curr = arr2[i];
            int count = map.getOrDefault(curr, 0);
            map.remove(curr);
            for (int k = 0; k < count; k++) {
                ans[k + j] = curr;
            }
            j = j + count;
            i++;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int curr = entry.getKey();
            int count = entry.getValue();
            for (int k = 0; k < count; k++) {
                ans[k + j] = curr;
            }
            j = j + count;
        }
        return ans;
    }
}

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        int[] arr2 = { 2, 1, 4, 3, 9, 6 };
        Solution solution = new Solution();
        solution.relativeSortArray(arr1, arr2);
    }
}
