package t1_array.s2_medium.q19_maximumIceCreamBars;

import java.util.Arrays;

class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int ans = 0;
        int n = costs.length;
        int max = Arrays.stream(costs).max().getAsInt();
        int[] frequencies = new int[max + 1];
        for (int i = 0; i < n; i++) {
            int cost = costs[i];
            frequencies[cost]++;
        }
        int spend = 0;
        for (int cost = 0; cost < frequencies.length; cost++) {
            int frequency = frequencies[cost];

            for (int i = 1; i <= frequency; i++) {
                if (spend + cost <= coins) {
                    ans++;
                    spend += cost;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}

public class MaximumIceCreamBars {
    public static void main(String[] args) {
        int[] costs = { 1, 3, 2, 4, 1 };
        int coins = 7;
        Solution solution = new Solution();
        solution.maxIceCream(costs, coins);
    }
}
