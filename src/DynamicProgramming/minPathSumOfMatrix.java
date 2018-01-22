package DynamicProgramming;

/**
 * Created by yyt on 2018/1/5.
 */
public class minPathSumOfMatrix {

    // 用很多空间的简单方法
    public static int solutions(int[][] v) {
        int M = v.length;
        int N = v[0].length;
        int[][] dp = new int[M][N];
        dp[0][0] = v[0][0];
        // 首先要赋一个值。
        for (int i = 1; i < M; i++) {
            dp[i][0] = dp[i - 1][0] + v[i][0];
        }
        for (int i = 1; i < N; i++) {
            dp[0][i] = dp[0][i - 1] + v[0][i];
        }

        for (int i = 1; i < M; i++) {
            for (int j = 1; j < N; j++) {
                dp[i][j] = Math.min( dp[i - 1][j] + v[i][j], dp[i][j - 1] + v[i][j] );

            }
        }
        return dp[M - 1][N - 1];
    }

    // 只用极少空间的优化方法
    public static int solutions2(int[][] v) {
        int M = v.length;
        int N = v[0].length;
        if (M >= N) {
            int[] A = new int[N];
            A[0] = v[0][0];
            for (int i = 1; i < N; i++) {
                A[i] = A[i-1] + v[0][i];
            }
            for(int i=1;i<M;i++){
                A[0] = A[0] + v[i][0];
                for (int j = 1; j < N ; j++) {
                    A[j] = Math.min(A[j],A[j-1])+v[i][j];
                }
            }
            return A[N-1];
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] v = {{2, 3, 2, 1}, {1, 2, 3, 4}, {2, 0, 0, 1}, {3, 6, 7, 2}};
        solutions( v );
        solutions2(v);

    }
}
