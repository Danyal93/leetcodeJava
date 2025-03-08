package t1_array.s3_hard.q4_fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int k = j + 1;
                int l = n - 1;
                while (k < l) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    sum += nums[l];
                    if (sum == target) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        result.add(temp);
                        while (k < n - 1 && nums[k] == nums[k + 1])
                            k++;
                        while (l > 0 && nums[l] == nums[l - 1])
                            l--;
                        k++;
                        l--;
                    } else if (sum > target) {
                        l--;
                    } else {
                        k++;
                    }
                }
                while (j < n - 1 && nums[j] == nums[j + 1])
                    j++;
            }
            while (i < n - 1 && nums[i] == nums[i + 1])
                i++;
        }
        return result;
    }
}

public class FourSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = { 1000000000,1000000000,1000000000,1000000000 };
        int target = -294967296;
        solution.fourSum(nums, target);
    }

}
