package DynamicProgramming;

/**
 * Created by yyt on 2018/2/1.
 */
//You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
// Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
//
//        Find out how many ways to assign symbols to make sum of integers equal to target S.
//
//        Example 1:
//        Input: nums is [1, 1, 1, 1, 1], S is 3.
//        Output: 5
//        Explanation:
//
//        -1+1+1+1+1 = 3
//        +1-1+1+1+1 = 3
//        +1+1-1+1+1 = 3
//        +1+1+1-1+1 = 3
//        +1+1+1+1-1 = 3
//
//        There are 5 ways to assign symbols to make the sum of nums be target 3.
//        Note:
//        The length of the given array is positive and will not exceed 20.
//        The sum of elements in the given array will not exceed 1000.
//        Your output answer is guaranteed to be fitted in a 32-bit integer.
public class TargetSum {
// 先思考一个数学问题
    //sum(P) - sum(N) = S
    // sum(P) + sum(N) = sum(ALL)
    // 2 * sum(p) = sums(ALL) + S

    public int findTargetSumWays(int[] nums, int S) {
        int sumAll = 0;
        for (int num:nums)
            sumAll+=num;
        // 首先要满足的第一个条件，必须是偶数
        if ((sumAll+S) %2 ==1 || sumAll < S)
            return 0;
        int target = (sumAll+S) / 2;
        return subsetSum( nums, target);
    }
    // 这个算法是用来计算子集数目的。
    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int num : nums)
            // 这个要保证所有的数都是正数
            for (int i = s; i >= num; i--)
                // dp[i] 表示能到达i的数字组合的个数
                dp[i] += dp[i - num];
        return dp[s];
    }

    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        int[] nums = {1, 1,0,0,1,0};
        System.out.println( t.findTargetSumWays( nums, 3 ) );
    }
}
