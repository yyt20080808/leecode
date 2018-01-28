package DynamicProgramming;

import Array.MajorityElement;

/**
 * Created by yyt on 2018/1/25.
 */
//221
// Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
//        For example, given the following matrix:
//
//        1 0 1 0 0
//        1 0 1 1 1
//        1 1 1 1 1
//        1 0 0 1 0
//        Return 4.
public class MaxSquare {
    public MaxSquare() {

    }

    public int maximalSquare(char[][] matrix) {
        int M = matrix.length;
        if(M == 0)
            return 0;
        int N = matrix[0].length;
        int[][] dp = new int[M][N];
        int res = 0;
        for (int i = 0; i < M; i++)
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
                res = 1;
            }

        for (int j = 0; j < N; j++)
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
                res = 1;
            }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min( Math.min( dp[i - 1][j], dp[i][j - 1] ), dp[i - 1][j - 1] ) + 1;
                    res = Math.max( res, dp[i][j] );
                }
            }
        }
        return res * res;
    }

    public static void main(String[] args) {
        char[][] a = {{'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '1', '1', '1'}};
        char[][] b ={{'1'}};
        MaxSquare m = new MaxSquare();
        System.out.println(m.maximalSquare( b ));
    }
}
