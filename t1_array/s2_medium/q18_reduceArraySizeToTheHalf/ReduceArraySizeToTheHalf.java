package t1_array.s2_medium.q18_reduceArraySizeToTheHalf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public int minSetSize(int[] arr) {
        int ans = 0;
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        ArrayList<Integer> countings = new ArrayList<>(Collections.nCopies(n + 1, 0));
        for (int val : map.values()) {
            countings.set(val, countings.get(val) + 1);
        }
        int curr = 0;
        for (int i = n; i >= 0; i--) {
            int freq = countings.get(i);
            for (int j = 0; j < freq; j++) {
                curr += i;
                ans++;
                if (curr >= n / 2) {
                    return ans;
                }
            }
        }
        return ans;
    }
}

public class ReduceArraySizeToTheHalf {
    public static void main(String[] args) {
        int[] arr = { 3, 3, 3, 3, 5, 5, 5, 2, 2, 7 };
        Solution solution = new Solution();
        solution.minSetSize(arr);
    }
}
