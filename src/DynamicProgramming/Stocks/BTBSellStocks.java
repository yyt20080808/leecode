package DynamicProgramming.Stocks;

/**
 * Created by yyt on 2018/1/28.
 */
public class BTBSellStocks {
    public BTBSellStocks() {

    }

    public int maxProfit(int[] prices) {
        // 感觉从后往前好一些，先找到一个tempMax 从后面
        int N = prices.length;
        if (N < 2)
            return 0;
        int dp = 0;
        int sellPrice = prices[N - 1];
        int diff = 0;
        for (int i = N - 2; i >= 0; i--) {
            diff = sellPrice - prices[i];
            // dp 存的是从后往前的 最大值， 比如 i 到N-1 最大差值， i-1到N-1最大差值是
            // dp[i] = Math.max( dp[i+1],diff );
            dp = Math.max( dp,diff );
            if (diff < 0) {
                sellPrice = prices[i];
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        BTBSellStocks3 b = new BTBSellStocks3();
        b.maxProfit( nums );
    }
}
