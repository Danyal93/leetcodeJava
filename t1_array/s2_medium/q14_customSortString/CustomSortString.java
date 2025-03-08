package t1_array.s2_medium.q14_customSortString;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int i = 0;
        while (i < order.length()) {
            char curr = order.charAt(i);
            int count = map.getOrDefault(curr, 0);
            map.remove(curr);
            for (int k = 0; k < count; k++) {
                result.append(curr);
            }
            i++;
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char curr = entry.getKey();
            int count = entry.getValue();
            for (int k = 0; k < count; k++) {
                result.append(curr);
            }
        }
        return result.toString();
    }
}

public class CustomSortString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String order = "cba";
        String s = "abcd";
        solution.customSortString(order, s);
    }
}
