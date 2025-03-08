package t1_array.s2_medium.q8_arrayLeaders;

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int maxSoFar = arr[n - 1];
        for (int i = n - 1; i >= 0; i--) {
            int value = arr[i];
            if (value >= maxSoFar) {
                result.add(value);
                maxSoFar = value;
            }
        }
        Collections.reverse(result);
        return result;
    }
}

public class ArrayLeaders {
    public static void main(String[] args) {
        int[] arr = { 16, 17, 4, 3, 5, 2 };
        Solution.leaders(arr);
    }
}
