package DynamicProgramming;

/**
 * Created by yyt on 2018/1/23.
 */
//You are a professional robber planning to rob houses along a street.
//        Each house has a certain amount of money stashed,
//        the only constraint stopping you from robbing each of them is that
//        adjacent houses have security system connected and it will automatically contact the police
//        if two adjacent houses were broken into on the same night.
//
//        Given a list of non-negative integers representing the amount of money of each house,
//        determine the maximum amount of money you can rob tonight without alerting the police.
public class HouseRobber {

    public static int rob(int[] nums) {
        int N = nums.length;
        if(N==0)
            return 0;
        if(N==1)
            return nums[0];
        int []dp = new int[N+1];
        dp[0] = 0;
        dp[1] = nums[0];
        dp[2] =  nums[1];
        for (int i = 3; i <= N; i++) {
            dp[i] = Math.max( dp[i-2],dp[i-3] )+ nums[i-1];
        }
        return Math.max( dp[N-1],dp[N] );
    }

        public static void main(String[] args) {
            int[] nums = {1,4,5,6,3,3,7,12,6};
            System.out.print(rob( nums ) );
    }
}
