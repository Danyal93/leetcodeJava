package t1_array.s3_hard.q3_threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int currentSum = nums[i] + nums[j] + nums[k];
                if (currentSum == 0) {

                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);
                    while (j < n - 1 && nums[j] == nums[j + 1])
                        j++;
                    while (k > 0 && nums[k] == nums[k - 1])
                        k--;
                    j++;
                    k--;
                } else if (currentSum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
            while (i < n - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }
}

public class ThreeSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { -1, -1, 0, 1, 2, 2, 2, -1, -4 };
        solution.threeSum(nums);
    }
}
