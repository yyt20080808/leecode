package DynamicProgramming.Stocks;

/**
 * Created by yyt on 2018/1/28.
 */
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit. You may complete at most k transactions.
public class BTBSellStocks4 {
    public BTBSellStocks4() {

    }
    // 这次 最多限制了k 次，所以要用动态规划了，难受。
    public int maxProfit(int k, int[] prices) {
        int N = prices.length;
        if(N<2)
            return 0;
        // 防止异常的输入输出。
        if(k>= N)
            return maxProfit22222222(prices);
        int[][] local = new int[N][k+1];
        int[][] global = new int[N][k+1];
        for (int i = 1; i < N; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1; j <= k ; j++) {
                // 在第i天完成 第j 次交易 表示的是 local[i][j]
                local[i][j] = Math.max(global[i-1][j-1]+Math.max( diff,0 ),local[i - 1][j] + diff);
                global[i][j] = Math.max( local[i][j],global[i-1][j] );
            }
        }
        return global[N-1][k];
    }
    // 无限次的买卖次数了
    private int maxProfit22222222(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }
        return total;
    }

    public static void main(String[] args) {
        int[] nums = {1, 12,1,2,3,5,4,5};
        BTBSellStocks4 b = new BTBSellStocks4();
        b.maxProfit(4, nums );
    }
}
