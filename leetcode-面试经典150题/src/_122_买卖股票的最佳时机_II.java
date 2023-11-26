public class _122_买卖股票的最佳时机_II {
    public int maxProfit(int[] prices) {
        int cur_min =prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i-1]){
                res += Math.max(0, prices[i-1] - cur_min);
                cur_min = prices[i];
            }
        }
        return res;
    }
}
