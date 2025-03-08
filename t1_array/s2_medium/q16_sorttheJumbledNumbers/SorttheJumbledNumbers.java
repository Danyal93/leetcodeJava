package t1_array.s2_medium.q16_sorttheJumbledNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        int n = nums.length;
        List<Integer[]> storedPair = new ArrayList<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int mappedValue = 0;
            int temp = nums[i];
            int place = 1;

            do {
                mappedValue = place * mapping[temp % 10] + mappedValue;
                place *= 10;
                temp /= 10;
            } while (temp != 0);
            storedPair.add(new Integer[] { mappedValue, i });
            // THIS IS ALSO WORKING
            // String number = Integer.toString(nums[i]);
            // String formed = "";
            // for (int j = 0; j < number.length(); j++) {
            // formed = formed + Integer.toString(mapping[number.charAt(j) - '0']);
            // }
            // int mappedValue = Integer.parseInt(formed);
            // storedPair.add(new Integer[] { mappedValue, i });
        }
        Collections.sort(storedPair, (a, b) -> a[0].compareTo(b[0]));
        for (int i = 0; i < ans.length; i++) {
            ans[i] = nums[storedPair.get(i)[1]];
        }
        return ans;
    }
}

public class SorttheJumbledNumbers {
    public static void main(String[] args) {
        int[] mapping = { 8, 9, 4, 0, 2, 1, 3, 5, 7, 6 };
        int[] nums = { 991, 338, 38 };
        Solution solution = new Solution();
        solution.sortJumbled(mapping, nums);
    }
}
