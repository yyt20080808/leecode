package DynamicProgramming.MinimaxGame;

/**
 * Created by yyt on 2018/3/1.
 */
//Given an array of scores that are non-negative integers. Player 1 picks one of the numbers
// from either end of the array followed by the player 2 and then player 1 and so on. Each
// time a player picks a number, that number will not be available for the next player.
// This continues until all the scores have been chosen. The player with the maximum score wins.
//
//        Given an array of scores, predict whether player 1 is the winner. You can assume each
// player plays to maximize his score.
//
//        Example 1:
//        Input: [1, 5, 2]
//        Output: False
//        Explanation: Initially, player 1 can choose between 1 and 2.
//        If he chooses 2 (or 1), then player 2 can choose from 1 (or 2) and 5. If player
// 2 chooses 5, then player 1 will be left with 1 (or 2).
//        So, final score of player 1 is 1 + 2 = 3, and player 2 is 5.
//        Hence, player 1 will never be the winner and you need to return False.
//        Example 2:
//        Input: [1, 5, 233, 7]
//        Output: True
//        Explanation: Player 1 first chooses 1. Then player 2 have to choose between 5 and 7.
// No matter which number player 2 choose, player 1 can choose 233.
//        Finally, player 1 has more score (234) than player 2 (12), so you need to return True
// representing player1 can win.
//        Note:
//        1 <= length of the array <= 20.
//        Any scores in the given array are non-negative integers and will not exceed 10,000,000.
//        If the scores of both players are equal, then player 1 is still the winner.

public class PredicttheWinner {
    public boolean PredictTheWinner(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N][N];
        int[] sum = new int[N];
        sum[0] = nums[0];
        dp[0][0] = nums[0];
        for (int i = 1; i < N; i++) {
            sum[i] = sum[i - 1] + nums[i];
            dp[i][i] = nums[i];
        }
        for (int i = 1; i < N; i++) {
            for (int j = 0; i + j < N; j++) {
                // dp[j+1][i+j] dp[j][i+j-1] 是另一个选手选择的结果，按照minimax，哪个大就选哪个
                int a = (sum[i + j] - sum[j] + nums[j]) - dp[j + 1][i + j];
                int b = (sum[i + j] - sum[j] + nums[j]) - dp[j][i + j - 1];
                // 加上的 nums[j] 的目的是防止出现sum[j-1] ,导致 麻烦的出现
                dp[j][i + j] = Math.max( a, b );
            }
        }
        return 2 * dp[0][N - 1] >= sum[N - 1];
    }

    public static void main(String[] args) {

    }
}
