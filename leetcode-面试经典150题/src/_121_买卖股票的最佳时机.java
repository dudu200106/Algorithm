public class _121_买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {
        int n =prices.length;
        int pre_min = prices[0]; // 之前最小值
        int res =0;
        for (int i = 1; i <n; i++) {
            if(prices[i]>pre_min){
                res = Math.max(res, prices[i] - pre_min);
            }else{
                pre_min = prices[i];
            }
        }
        return res;
    }

}
