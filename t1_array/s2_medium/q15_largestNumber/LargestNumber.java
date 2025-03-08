package t1_array.s2_medium.q15_largestNumber;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder result = new StringBuilder();
        ArrayList<String> numbers = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            numbers.add(Integer.toString(nums[i]));
        }
        Collections.sort(numbers, (a, b) -> (b + a).compareTo(a + b));
        if (numbers.get(0).equals("0")) {
            return "0";
        }
        for (String numStr : numbers) {
            result.append(numStr);
        }
        return result.toString();
    }
}

public class LargestNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 3, 30, 34, 5, 9 };
        solution.largestNumber(nums);
    }
}
