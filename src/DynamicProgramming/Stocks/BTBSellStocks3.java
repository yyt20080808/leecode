package DynamicProgramming.Stocks;

/**
 * Created by yyt on 2018/1/28.
 */
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit. You may complete at most two transactions.
public class BTBSellStocks3 {
    public BTBSellStocks3() {

    }

    public int maxProfit(int[] prices) {
        int N = prices.length;
        if (N < 2)
            return 0;
        int[] back = new int[N];
        int sellPrice = prices[N - 1];
        int diff = 0;
        for (int i = N - 2; i >= 0; i--) {
            diff = sellPrice - prices[i];
            // dp 存的是从后往前的 最大值， 比如 i 到N-1 最大差值， i-1到N-1最大差值是
            // dp[i] = Math.max( dp[i+1],diff );
            back[i] = Math.max( back[i + 1], diff );
            if (diff < 0) {
                sellPrice = prices[i];
            }
        }

        int[] forward = new int[N];
        int buyPrice = prices[0];
        diff = 0;
        for (int i = 1; i < N; i++) {
            diff = prices[i] - buyPrice;
            forward[i] = Math.max( forward[i - 1], diff );
            if (diff < 0) {
                buyPrice = prices[i];
            }
        }
        // res 先存一次的。
        int res = Math.max( forward[N-1],back[0] );
        for (int i = 0; i < N - 1; i++) {
            // forward 从前往后
            res = Math.max( res, forward[i] + back[i + 1] );
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2,4};
        BTBSellStocks3 b = new BTBSellStocks3();
        b.maxProfit( nums );
    }
}
