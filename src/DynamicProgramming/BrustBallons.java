package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by yyt on 2018/2/5.
 */
//Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on
// it represented by array nums. You are asked to burst all the balloons. If the
// you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
// Here left and right are adjacent indices of i. After the burst, the left and right
// then becomes adjacent.
//
//        Find the maximum coins you can collect by bursting the balloons wisely.
//
//        Note:
//        (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore
// you can not burst them.
//        (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
//
//        Example:
//
//        Given [3, 1, 5, 8]
//
//        Return 167
//
//        nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
//        coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
//

public class BrustBallons {
    public BrustBallons() {

    }

    public int maxCoins(int[] nums) {
        int N = nums.length;
        int[] copy = new int[N + 2];
        for (int i = 1; i <= N; i++)
            copy[i] = nums[i - 1];
        copy[0] = 1;
        copy[N + 1] = 1;
        int[][] dp = new int[N + 2][N + 2];
//        for (int i = 0; i < N; i++) {
//            Arrays.fill(dp[i],1);
//        }
        // 这是一个步伐的问题，k 是步骤
        for (int k = 2; k < N + 2; k++) {
            for (int left = 0; left < N + 2 - k; left++) {
                int right = left+k;
                for (int i = left+1; i < right; i++) {
                    // temp 为什么乘以的是 right 和 left， 说明temp 是最后被拿走的数字
                    int temp = copy[i] * copy[left] * copy[right];
                    dp[left][right] = Math.max( dp[left][right],temp + dp[left][i]+dp[i][right] );
                }
            }
        }
        return dp[0][N+1];
    }

    public static void main(String[] args) {
        BrustBallons b = new BrustBallons();
        int[] nums = {3, 1, 5, 8};
        System.out.print( b.maxCoins( nums ) );
    }
}
