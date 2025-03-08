package t1_array.s2_medium.q5_bestTimeToBuyAndSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int minStock = prices[0];
        for (int i = 0; i < prices.length; i++) {
            int currentProfite = prices[i] - minStock;
            ans = Math.max(ans, currentProfite);
            minStock = Math.min(minStock, prices[i]);
        }
        return ans;
    }
}

public class BestTimeToBuyAndSellStock1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int prices[] = { 7, 1, 5, 3, 6, 4 };
        solution.maxProfit(prices);
    }
}
