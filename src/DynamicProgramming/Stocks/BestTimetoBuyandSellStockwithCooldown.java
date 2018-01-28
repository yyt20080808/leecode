package DynamicProgramming.Stocks;

/**
 * Created by yyt on 2018/1/28.
 */
//309
//    Say you have an array for which the ith element is the price of a given stock on day i.
//
//            Design an algorithm to find the maximum profit.
// You may complete as many transactions as you like (ie, buy one and sell one share of the
// stock multiple times) with the following restrictions:
//
//            You may not engage in multiple transactions at the same time
// (ie, you must sell the stock before you buy again).
//            After you sell your stock, you cannot buy stock on next day.
// (ie, cooldown 1 day)

//            Example:
//
//            prices = [1, 2, 3, 0, 2]
//            maxProfit = 3
//            transactions = [buy, sell, cooldown, buy, sell]
public class BestTimetoBuyandSellStockwithCooldown {
    public BestTimetoBuyandSellStockwithCooldown() {

    }
//    buy[i]表示在第i天之前最后一个操作是买，此时的最大收益。
//
//    sell[i]表示在第i天之前最后一个操作是卖，此时的最大收益。
//
//    rest[i]表示在第i天之前最后一个操作是冷冻期，此时的最大收益。
//
//    我们写出递推式为：
//
//    buy[i]  = max(rest[i-1] - price, buy[i-1])
//    sell[i] = max(buy[i-1] + price, sell[i-1])
//    rest[i] = max(sell[i-1], buy[i-1], rest[i-1])
    public int maxProfit(int[] prices) {

        int N = prices.length;
        if(N<2)
            return 0;
        int[] buy = new int[N];
        int[] sell = new int[N];
        int[] rest = new int[N];
        buy[0] = 0 - prices[0];

        for (int i = 1; i < N; i++) {
            // buy[i] 表示 在第i天所处的状态是准备卖的状态
            buy[i] = Math.max(rest[i-1] - prices[i],buy[i-1]);
            // sell[i] 表示 在第i天 是刚刚卖的状态
            sell[i] = Math.max( buy[i-1]+prices[i],rest[i-1] );
            rest[i] = Math.max( sell[i-1],rest[i-1]);
            // 其实可以优化，sell[i] 可以代表rest[i-1]
            // buy = max(prebuy ,pre_sell - prices[i])
            // sell 就是以前的sell 和今天sell的最大值
            // sell = max(pre_sell, pre_buy + price[i])
        }
        return sell[N-1];
    }
    public static void main(String[] args) {
        int [] nums = {1, 2};
        BestTimetoBuyandSellStockwithCooldown b = new BestTimetoBuyandSellStockwithCooldown();
        b.maxProfit( nums );
    }
}
