package DynamicProgramming.Stocks;

/**
 * Created by yyt on 2018/1/28.
 */
//Say you have an array for which the ith element is the price of a given stock on day i.
//
//        Design an algorithm to find the maximum profit.
//        You may complete as many transactions as you like
//        (ie, buy one and sell one share of the stock multiple times).
//        However, you may not engage in multiple transactions at the same time
//        (ie, you must sell the stock before you buy again).
public class BTBSellStocks2 {
    public BTBSellStocks2() {

    }
    // 感觉这个只要后面的比前面的大，直接卖就好了
    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,4};
        BTBSellStocks2 b = new BTBSellStocks2();
        b.maxProfit( nums );
    }
}
